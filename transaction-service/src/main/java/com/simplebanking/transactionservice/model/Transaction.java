package com.simplebanking.transactionservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "a_transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private LocalDateTime createdDate;

    private BigDecimal amount;

    private String transactionType;

    private String transactionStatus;


    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDateTime.now(ZoneOffset.of("+03:00"));
    }


}
