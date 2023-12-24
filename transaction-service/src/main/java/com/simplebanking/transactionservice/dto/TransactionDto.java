package com.simplebanking.transactionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

    private String id;

    private LocalDateTime createdDate;

    private BigDecimal amount;

    private String transactionType;

    private String transactionStatus;

}
