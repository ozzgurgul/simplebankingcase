package com.simplebanking.accountservice.service;

import com.simplebanking.accountservice.client.CustomerServiceClient;
import com.simplebanking.accountservice.client.TransactionServiceClient;
import com.simplebanking.accountservice.dto.*;
import com.simplebanking.accountservice.exception.AccountNotFoundException;
import com.simplebanking.accountservice.exception.TransactionOperationFailedException;
import com.simplebanking.accountservice.exception.UnExpectedTransactionTypeException;
import com.simplebanking.accountservice.model.Account;
import com.simplebanking.accountservice.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    private final CustomerServiceClient customerServiceClient;

    private final TransactionServiceClient transactionServiceClient;

    private final static String TRANSACTION_STATUS_OK = "SUCCESFULL";
    private final static String TRANSACTION_STATUS_FAIL = "FAIL";

    public AccountService(AccountRepository accountRepository, CustomerServiceClient customerServiceClient, TransactionServiceClient transactionServiceClient) {
        this.accountRepository = accountRepository;
        this.customerServiceClient = customerServiceClient;
        this.transactionServiceClient = transactionServiceClient;
    }

    public AccountDto createAccount() {
        Account newAccount = new Account();
        newAccount.setBalance(BigDecimal.ZERO);
        newAccount.setAccountNo("" + ThreadLocalRandom.current().nextLong(1000_0000_0000_0000L, 9999_9999_9999_9999L + 1));
        accountRepository.save(newAccount);
        return new AccountDto(newAccount.getId(), newAccount.getAccountNo(), newAccount.getBalance(), newAccount.getCustomerId(), newAccount.getTransactions());
    }


    public void defineAccountToCustomer(AddAccountRequest request) {
        String customerId = customerServiceClient.getCustomerByTcNo(request.getTcNo()).getBody().getId();

        Account account = this.getAccountById(request.getId());

        account.setCustomerId(customerId);

        accountRepository.save(account);
    }

    public GetAccountResponse getAccountByAccountNo(String accountNo) {

        Account account = accountRepository.findAccountByAccountNo(accountNo)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with account number : " + accountNo));
        List<TransactionDto> transactionDtosList = new ArrayList<>();
        List<String> idList = account.getTransactions();

        for (String id : idList) {
            transactionDtosList.add(transactionServiceClient.getTransactionById(id).getBody());
        }

        return new GetAccountResponse(account.getId(), account.getAccountNo(), account.getBalance(),
                customerServiceClient.getCustomerById(account.getCustomerId()).getBody(), transactionDtosList);


    }

    public void createTransaction(CreateAccountTransactionRequest request) {

        Account account = this.getAccountById(request.getId());

        BigDecimal balance = account.getBalance();
        BigDecimal amount = request.getCreateTransactionRequest().getAmount();
        BigDecimal totalBalance = BigDecimal.ZERO;
        String transactionType = request.getCreateTransactionRequest().getTransactionType();

        switch (transactionType) {
            case "deposit":
                totalBalance = balance.add(amount);
                account.setBalance(totalBalance);
                request.getCreateTransactionRequest().setTransactionStatus(TRANSACTION_STATUS_OK);
                break;
            case "withDraw":
                if (balance.compareTo(amount) >= 0) {
                    totalBalance = balance.subtract(amount);
                    account.setBalance(totalBalance);
                    request.getCreateTransactionRequest().setTransactionStatus(TRANSACTION_STATUS_OK);
                } else {
                    request.getCreateTransactionRequest().setTransactionStatus(TRANSACTION_STATUS_FAIL);
                }

                break;
            case "billPayment":
                if (balance.compareTo(amount) >= 0) {
                    totalBalance = balance.subtract(amount);
                    account.setBalance(totalBalance);
                    request.getCreateTransactionRequest().setTransactionStatus(TRANSACTION_STATUS_OK);
                } else {
                    request.getCreateTransactionRequest().setTransactionStatus(TRANSACTION_STATUS_FAIL);
                }

                break;
            default:
                throw new UnExpectedTransactionTypeException("Unexpected value: " + transactionType);
        }
        String transactionDtoId = transactionServiceClient.createDepositTransaction(request.getCreateTransactionRequest()).getBody().getId();
        account.getTransactions()
                .add(transactionDtoId);
        accountRepository.save(account);

        if (request.getCreateTransactionRequest().getTransactionStatus().equals(TRANSACTION_STATUS_FAIL)) {
            throw new TransactionOperationFailedException("Insufficient balance");
        }
    }


    private Account getAccountById(String id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id :" + id));
    }

}
