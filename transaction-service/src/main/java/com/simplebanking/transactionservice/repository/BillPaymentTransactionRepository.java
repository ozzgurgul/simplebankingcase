package com.simplebanking.transactionservice.repository;

import com.simplebanking.transactionservice.model.BillPaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillPaymentTransactionRepository extends JpaRepository<BillPaymentTransaction,String> {
}
