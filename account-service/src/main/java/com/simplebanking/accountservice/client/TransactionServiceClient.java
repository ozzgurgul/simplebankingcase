package com.simplebanking.accountservice.client;

import com.simplebanking.accountservice.dto.CreateTransactionRequest;
import com.simplebanking.accountservice.dto.TransactionDto;
import com.simplebanking.accountservice.dto.UpdateTransactionDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "transaction-service",path = "/v1/transaction")
public interface TransactionServiceClient {

    @PostMapping
    ResponseEntity<TransactionDto> createDepositTransaction(@RequestBody CreateTransactionRequest request);


    @GetMapping("/{id}")
    ResponseEntity<TransactionDto> getTransactionById(@RequestParam String id);

    @PutMapping
    void updateTransactionById(@RequestBody UpdateTransactionDto request);



}
