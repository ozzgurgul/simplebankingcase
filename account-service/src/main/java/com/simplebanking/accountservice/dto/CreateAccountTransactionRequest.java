package com.simplebanking.accountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountTransactionRequest {

    private String id;

    private CreateTransactionRequest createTransactionRequest;
}
