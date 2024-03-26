package com.kevin.bioskop.service.impl;

import com.kevin.bioskop.Model.request.CustomerRequest;
import com.kevin.bioskop.entity.Customer;
import com.kevin.bioskop.repository.CustomerRepository;
import com.kevin.bioskop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createNasabah(CustomerRequest customerRequest) {
        Customer newCustomer = Customer.builder()
                .name(customerRequest.getName())
                .birthDate(customerRequest.getBirthDate())
                .build();

        return customerRepository.save(newCustomer);
    }
}
