package com.simplebanking.transactionservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class DepositTransaction extends Transaction{


}
