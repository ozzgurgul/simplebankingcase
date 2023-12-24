package com.simplebanking.transactionservice.service;

import com.simplebanking.transactionservice.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    private TransactionService transactionService;

    private TransactionRepository transactionRepository;



    @BeforeEach
    void setUp(){

        transactionRepository = Mockito.mock(TransactionRepository.class);

        transactionService = new TransactionService(transactionRepository);

    }


}