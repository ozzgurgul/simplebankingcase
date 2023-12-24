package com.simplebanking.accountservice.dto;



import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountDto {

    private String id;

    private String accountNo;

    private BigDecimal balance;

    private String customerId;

    private List<String> transactions = new ArrayList<>();
}
