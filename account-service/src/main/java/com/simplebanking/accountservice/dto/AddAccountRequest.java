package com.simplebanking.accountservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddAccountRequest {

    private String id;
    private String tcNo;

}
