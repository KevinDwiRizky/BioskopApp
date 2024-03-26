package com.kevin.bioskop.service;

import com.kevin.bioskop.Model.request.CustomerRequest;
import com.kevin.bioskop.entity.Customer;
import org.springframework.data.domain.Page;

public interface CustomerService {
    Customer createCustomer(CustomerRequest customerRequest);

    Page<Customer> getAllCustomer(Integer page, Integer size);

    Customer getCustomerById(String id);

    Customer updateCustomer(Customer customer);

    void  deleteCustomerById(String id);

}
