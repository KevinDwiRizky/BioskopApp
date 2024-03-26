package com.kevin.bioskop.controller;

import com.kevin.bioskop.Model.request.CustomerRequest;
import com.kevin.bioskop.Model.response.WebResponse;
import com.kevin.bioskop.entity.Customer;
import com.kevin.bioskop.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
        Customer newCustomer = customerService.createNasabah(customerRequest);
        WebResponse<Customer> response = WebResponse.<Customer>builder()
                .status(HttpStatus.CREATED.getReasonPhrase())
                .message("Success add data")
                .data(newCustomer)
                .build();
        return ResponseEntity.ok(response);
    }


}
