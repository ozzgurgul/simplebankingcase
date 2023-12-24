package com.simplebanking.transactionservice.repository;

import com.simplebanking.transactionservice.model.WithDrawalTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithDrawalTransactionRepository extends JpaRepository<WithDrawalTransaction,String> {
}
