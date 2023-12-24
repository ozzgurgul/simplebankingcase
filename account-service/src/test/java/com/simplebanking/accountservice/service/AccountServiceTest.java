package com.simplebanking.accountservice.service;

import com.simplebanking.accountservice.client.CustomerServiceClient;
import com.simplebanking.accountservice.client.TransactionServiceClient;
import com.simplebanking.accountservice.dto.AccountDto;
import com.simplebanking.accountservice.dto.AddAccountRequest;
import com.simplebanking.accountservice.dto.CustomerDto;
import com.simplebanking.accountservice.dto.CustomerIdDto;
import com.simplebanking.accountservice.model.Account;
import com.simplebanking.accountservice.repository.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    private AccountService accountService;
    private AccountRepository accountRepository;
    private CustomerServiceClient customerServiceClient;
    private TransactionServiceClient transactionServiceClient;


    @BeforeEach
    void setUp(){

        accountRepository = Mockito.mock(AccountRepository.class);
        customerServiceClient = Mockito.mock(CustomerServiceClient.class);
        transactionServiceClient = Mockito.mock(TransactionServiceClient.class);


        accountService = new AccountService(accountRepository,customerServiceClient,transactionServiceClient);

    }


    @Test
    void defineAccountToCustomer(){



    }

}