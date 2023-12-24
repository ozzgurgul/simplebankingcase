package com.simplebanking.customerservice.repository;

import com.simplebanking.customerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CustomerRepository extends JpaRepository<Customer,String> {


    Optional<Customer> getCustomerByTcNo(String tcNo);

    Optional<Customer> getCustomerById(String id);

}
