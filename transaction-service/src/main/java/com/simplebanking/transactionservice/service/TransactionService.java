package com.simplebanking.transactionservice.service;

import com.simplebanking.transactionservice.dto.CreateTransactionRequest;
import com.simplebanking.transactionservice.dto.TransactionDto;
import com.simplebanking.transactionservice.exception.TransactionNotFoundException;
import com.simplebanking.transactionservice.exception.UnExpectedTransactionTypeException;
import com.simplebanking.transactionservice.model.BillPaymentTransaction;
import com.simplebanking.transactionservice.model.DepositTransaction;
import com.simplebanking.transactionservice.model.Transaction;
import com.simplebanking.transactionservice.model.WithDrawalTransaction;
import com.simplebanking.transactionservice.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    public TransactionDto createTransaction(CreateTransactionRequest request) {

        Transaction transaction;


        switch (request.getTransactionType()) {

            case "deposit":
                transaction = new DepositTransaction();
                break;
            case "withDraw":
                transaction = new WithDrawalTransaction();
                break;
            case "billPayment":
                transaction = new BillPaymentTransaction();
                break;
            default:
                throw new UnExpectedTransactionTypeException("Unexpected value: " + request.getTransactionType());
        }
        transaction.setTransactionType(request.getTransactionType());
        transaction.setAmount(request.getAmount());
        transaction.setTransactionStatus(request.getTransactionStatus());
        transactionRepository.save(transaction);

        return new TransactionDto(
                transaction.getId(),
                transaction.getCreatedDate(),
                transaction.getAmount(),
                transaction.getTransactionType(),
                transaction.getTransactionStatus());

    }

    public TransactionDto getTransactionById(String id) {
        return transactionRepository.findById(id)
                .map(transaction -> new TransactionDto(transaction.getId(),
                        transaction.getCreatedDate(), transaction.getAmount(), transaction.getTransactionType(), transaction.getTransactionStatus()))
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found with id : " + id));
    }

}
