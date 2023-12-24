package com.simplebanking.accountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAccountResponse {

    private String id;

    private String accountNo;

    private BigDecimal balance;

    private CustomerDto customerDto;

    private List<TransactionDto> transactions = new ArrayList<>();

}
