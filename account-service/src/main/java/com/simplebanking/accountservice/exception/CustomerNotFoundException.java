package com.simplebanking.accountservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException{


    private ExceptionMessage exceptionMessage;
    public CustomerNotFoundException(String message) {
        super(message);
    }

    public CustomerNotFoundException(ExceptionMessage exceptionMessage){
        this.exceptionMessage=exceptionMessage;
    }

    public ExceptionMessage getExceptionMessage(){
        return exceptionMessage;
    }

}
