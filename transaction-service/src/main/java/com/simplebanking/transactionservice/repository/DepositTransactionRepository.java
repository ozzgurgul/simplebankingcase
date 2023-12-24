package com.simplebanking.transactionservice.repository;

import com.simplebanking.transactionservice.model.DepositTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositTransactionRepository extends JpaRepository<DepositTransaction,String> {
}
