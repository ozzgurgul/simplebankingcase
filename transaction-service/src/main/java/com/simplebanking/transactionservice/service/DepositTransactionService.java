package com.simplebanking.transactionservice.service;

import com.simplebanking.transactionservice.model.DepositTransaction;
import com.simplebanking.transactionservice.repository.DepositTransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class DepositTransactionService {

    private final DepositTransactionRepository depositTransactionRepository;

    public DepositTransactionService(DepositTransactionRepository depositTransactionRepository) {
        this.depositTransactionRepository = depositTransactionRepository;
    }

    public void save(DepositTransaction depositTransaction){
        depositTransactionRepository.save(depositTransaction);
    }

}
