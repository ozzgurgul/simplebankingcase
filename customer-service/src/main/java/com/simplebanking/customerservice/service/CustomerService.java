package com.simplebanking.customerservice.service;

import com.simplebanking.customerservice.dto.CreateCustomerRequest;
import com.simplebanking.customerservice.dto.CustomerDto;
import com.simplebanking.customerservice.dto.CustomerIdDto;
import com.simplebanking.customerservice.exception.CustomerNotFoundException;
import com.simplebanking.customerservice.model.Customer;
import com.simplebanking.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public CustomerDto createCustomer(CreateCustomerRequest request) {
        Customer newCustomer = new Customer();
        newCustomer.setTcNo(request.getTcNo());
        newCustomer.setName(request.getName());
        newCustomer.setSurname(request.getSurname());
        customerRepository.save(newCustomer);

        CustomerDto customerDto = new CustomerDto();
        CustomerIdDto customerIdDto = new CustomerIdDto();

        customerIdDto.setId(newCustomer.getId());
        customerIdDto.setTcNo(newCustomer.getTcNo());

        customerDto.setCustomerIdDto(customerIdDto);
        customerDto.setName(newCustomer.getName());
        customerDto.setSurname(newCustomer.getSurname());

        return customerDto;
    }

    public CustomerIdDto findCustomerByTcNo(String tcNo) {
        return customerRepository.getCustomerByTcNo(tcNo)
                .map(customer -> new CustomerIdDto(customer.getId(), customer.getTcNo()))
                .orElseThrow(()-> new CustomerNotFoundException("Customer not found with tcNo: " + tcNo));
    }

    public CustomerDto findCustomerById(String id) {
        return customerRepository.getCustomerById(id)
                .map(customer ->
                        new CustomerDto(new CustomerIdDto(customer.getId(), customer.getTcNo()),customer.getName(), customer.getSurname()))
                .orElseThrow(()-> new CustomerNotFoundException("Customer not found with id: " +id));

    }
}
