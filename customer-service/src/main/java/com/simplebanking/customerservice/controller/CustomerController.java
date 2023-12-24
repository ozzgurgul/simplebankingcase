package com.simplebanking.customerservice.controller;

import com.simplebanking.customerservice.dto.CreateCustomerRequest;
import com.simplebanking.customerservice.dto.CustomerDto;
import com.simplebanking.customerservice.dto.CustomerIdDto;
import com.simplebanking.customerservice.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CreateCustomerRequest request){
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @GetMapping("/customer/{tcNo}")
    public ResponseEntity<CustomerIdDto> getCustomerByTcNo(@PathVariable String tcNo){
        return ResponseEntity.ok(customerService.findCustomerByTcNo(tcNo));
    }


    @GetMapping("/customer/id/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable String id){
        return ResponseEntity.ok(customerService.findCustomerById(id));
    }
}
