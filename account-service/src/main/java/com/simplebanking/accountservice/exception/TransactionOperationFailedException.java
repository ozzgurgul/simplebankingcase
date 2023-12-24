package com.simplebanking.accountservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TransactionOperationFailedException extends RuntimeException{
    public TransactionOperationFailedException(String message) {
        super(message);
    }
}
