package com.simplebanking.transactionservice.service;

import com.simplebanking.transactionservice.model.BillPaymentTransaction;
import com.simplebanking.transactionservice.repository.BillPaymentTransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class BillPaymentTransactionService {

    private final BillPaymentTransactionRepository billPaymentTransactionRepository;

    public BillPaymentTransactionService(BillPaymentTransactionRepository billPaymentTransactionRepository) {
        this.billPaymentTransactionRepository = billPaymentTransactionRepository;
    }

    public void save(BillPaymentTransaction billPaymentTransaction){
        billPaymentTransactionRepository.save(billPaymentTransaction);
    }

}
