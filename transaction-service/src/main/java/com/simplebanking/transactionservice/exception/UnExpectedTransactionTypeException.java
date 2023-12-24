package com.simplebanking.transactionservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnExpectedTransactionTypeException extends RuntimeException{

    public UnExpectedTransactionTypeException(String message) {
        super(message);
    }
}
