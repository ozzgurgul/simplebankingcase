package com.simplebanking.customerservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {

    private CustomerIdDto customerIdDto;

    private String name;

    private String surname;

}
