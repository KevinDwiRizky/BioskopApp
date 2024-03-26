package com.kevin.bioskop.service;

import com.kevin.bioskop.Model.request.CustomerRequest;
import com.kevin.bioskop.entity.Customer;

public interface CustomerService {
    Customer createNasabah(CustomerRequest customerRequest);
}
