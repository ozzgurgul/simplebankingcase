package com.simplebanking.transactionservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class WithDrawalTransaction extends Transaction {


}
