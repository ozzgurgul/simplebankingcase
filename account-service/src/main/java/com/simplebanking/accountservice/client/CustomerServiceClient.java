package com.simplebanking.accountservice.client;

import com.simplebanking.accountservice.dto.CustomerDto;
import com.simplebanking.accountservice.dto.CustomerIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service", path = "/v1/customer")
public interface CustomerServiceClient {


    @GetMapping("/customer/{tcNo}")
    ResponseEntity<CustomerIdDto> getCustomerByTcNo(@PathVariable String tcNo);


    @GetMapping("/customer/id/{id}")
    ResponseEntity<CustomerDto> getCustomerById(@PathVariable String id);


}
