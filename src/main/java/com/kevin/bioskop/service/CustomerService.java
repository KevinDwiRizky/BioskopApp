package com.kevin.bioskop.service;

import com.kevin.bioskop.Model.request.CustomerRequest;
import com.kevin.bioskop.entity.Customer;
import com.kevin.bioskop.entity.Rating;
import org.springframework.data.domain.Page;

public interface CustomerService {
    Customer createCustomer(CustomerRequest customerRequest);

    Page<Customer> getAllCustomer(Integer page, Integer size);

    Customer getCustomerById(String id);

    Customer updateCustomer(Customer customer);

    void  deleteCustomerById(String id);

    boolean isCustomerAllowedToWatch(Customer customer, Rating rating);
}
