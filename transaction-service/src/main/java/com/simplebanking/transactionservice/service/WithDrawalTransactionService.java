package com.simplebanking.transactionservice.service;

import com.simplebanking.transactionservice.model.WithDrawalTransaction;
import com.simplebanking.transactionservice.repository.WithDrawalTransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class WithDrawalTransactionService {

    private final WithDrawalTransactionRepository withDrawalTransactionRepository;

    public WithDrawalTransactionService(WithDrawalTransactionRepository withDrawalTransactionRepository) {
        this.withDrawalTransactionRepository = withDrawalTransactionRepository;
    }

    public void save(WithDrawalTransaction withDrawalTransaction){
        withDrawalTransactionRepository.save(withDrawalTransaction);
    }
}
