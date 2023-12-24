package com.simplebanking.accountservice.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionDto {

    private String id;

    private LocalDateTime createdDate;

    private BigDecimal amount;

    private String transactionType;

    private String transactionStatus;

}
