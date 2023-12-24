package com.simplebanking.customerservice.service;

import com.simplebanking.customerservice.dto.CreateCustomerRequest;
import com.simplebanking.customerservice.dto.CustomerDto;
import com.simplebanking.customerservice.dto.CustomerIdDto;
import com.simplebanking.customerservice.model.Customer;
import com.simplebanking.customerservice.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    private CustomerService customerService;

    private CustomerRepository customerRepository;


    @BeforeEach
    void setUp(){

        customerRepository = Mockito.mock(CustomerRepository.class);

        customerService = new CustomerService(customerRepository);
    }


    @Test
    void createCustomer(){
        CreateCustomerRequest request = new CreateCustomerRequest();
        CustomerDto customerDto = new CustomerDto();
        CustomerIdDto customerIdDto = new CustomerIdDto();

        request.setName("Özgür");
        request.setSurname("Gül");
        request.setTcNo("123456");

        Customer newCustomer = new Customer();
        newCustomer.setTcNo(request.getTcNo());
        newCustomer.setName(request.getName());
        newCustomer.setSurname(request.getSurname());

        Mockito.when(customerRepository.save(newCustomer)).thenReturn(newCustomer);
        Mockito.when(customerService.createCustomer(request)).thenReturn(customerDto);

        customerDto.setName(newCustomer.getName());
        customerDto.setSurname(newCustomer.getSurname());
        customerIdDto.setId(newCustomer.getId());
        customerIdDto.setTcNo(newCustomer.getTcNo());
        customerDto.setCustomerIdDto(customerIdDto);


       CustomerDto result = customerService.createCustomer(request);

       assertEquals(result,customerDto);

    }

}