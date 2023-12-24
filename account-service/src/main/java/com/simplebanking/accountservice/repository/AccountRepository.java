package com.simplebanking.accountservice.repository;

import com.simplebanking.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<Account,String> {

    Optional<Account> findAccountByAccountNo(String accountNo);


}
