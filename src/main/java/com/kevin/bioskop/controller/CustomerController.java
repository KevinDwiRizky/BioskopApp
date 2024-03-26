package com.kevin.bioskop.controller;

import com.kevin.bioskop.Model.request.CustomerRequest;
import com.kevin.bioskop.Model.response.PagingResponse;
import com.kevin.bioskop.Model.response.WebResponse;
import com.kevin.bioskop.entity.Customer;
import com.kevin.bioskop.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<?> getAllNasabah(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ){
        Page<Customer> customerList = customerService.getAllCustomer(page, size);

        PagingResponse pagingResponse = PagingResponse.builder()
                .page(page).size(size)
                .totalPages(customerList.getTotalPages())
                .totalElement(customerList.getTotalElements())
                .build();

        WebResponse<List<Customer>> response = WebResponse.<List<Customer>>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Get List data")
                .paging(pagingResponse)
                .data(customerList.getContent())
                .build();
        return ResponseEntity.ok(response);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getNasabahById(@PathVariable String id) {
        Customer findNasabah = customerService.getCustomerById(id);
        WebResponse<Customer> response = WebResponse.<Customer>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Get By Id ")
                .data(findNasabah)
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable String id){
        customerService.deleteCustomerById(id);
        WebResponse<String> response = WebResponse.<String>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Delete Customer By Id ")
                .data("OK")
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<?> updateCustomerById(@RequestBody Customer customer){
        Customer updateCustomer = customerService.updateCustomer(customer);
        WebResponse<Customer> response = WebResponse.<Customer>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Update customer By Id ")
                .data(updateCustomer)
                .build();
        return ResponseEntity.ok(response);
    }


}
