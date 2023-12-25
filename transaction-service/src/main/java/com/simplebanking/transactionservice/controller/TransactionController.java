package com.simplebanking.transactionservice.controller;

import com.simplebanking.transactionservice.dto.CreateTransactionRequest;
import com.simplebanking.transactionservice.dto.TransactionDto;
import com.simplebanking.transactionservice.dto.UpdateTransactionDto;
import com.simplebanking.transactionservice.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @PostMapping
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody CreateTransactionRequest request){
        return ResponseEntity.ok(transactionService.createTransaction(request));
    }


    @GetMapping("/{id}")
    public ResponseEntity<TransactionDto> getTransactionById(@RequestParam String id){
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    @PutMapping
    public void updateTransactionById(@RequestBody UpdateTransactionDto request){
        transactionService.updateTransactionById(request);
    }
}
