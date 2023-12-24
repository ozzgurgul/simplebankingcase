package com.simplebanking.accountservice.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<?> handle(AccountNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(),new HttpHeaders(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<?> handle(CustomerNotFoundException exception){
        return new ResponseEntity<>(exception.getExceptionMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<?> handle(TransactionNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnExpectedTransactionTypeException.class)
    public ResponseEntity<?> handle(UnExpectedTransactionTypeException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransactionOperationFailedException.class)
    public ResponseEntity<?> handle(TransactionOperationFailedException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
