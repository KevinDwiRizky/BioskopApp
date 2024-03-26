package com.kevin.bioskop.service.impl;

import com.kevin.bioskop.Model.request.CustomerRequest;
import com.kevin.bioskop.entity.Customer;
import com.kevin.bioskop.entity.Rating;
import com.kevin.bioskop.repository.CustomerRepository;
import com.kevin.bioskop.service.CustomerService;
import com.kevin.bioskop.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RatingService ratingService;

    @Override
    public Customer createCustomer(CustomerRequest customerRequest) {
        Customer newCustomer = Customer.builder()
                .name(customerRequest.getName())
                .birthDate(customerRequest.getBirthDate())
                .build();

        return customerRepository.save(newCustomer);
    }

    @Override
    public Page<Customer> getAllCustomer(Integer page, Integer size) {
        if (page <=0) {
            page = 1;
        }
        Pageable pageable = PageRequest.of(page-1, size);
        return customerRepository.findAll(pageable);

    }

    @Override
    public Customer getCustomerById(String id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) return optionalCustomer.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer with id : " + id + " Not Found");

    }

    @Override
    public Customer updateCustomer(Customer customer) {
        this.getCustomerById(customer.getId());
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(String id) {
        this.getCustomerById(id);
        customerRepository.deleteById(id);
    }


    // untuk menentukan izin
    public boolean isCustomerAllowedToWatch(Customer customer, Rating rating) {
        int customerAge = calculateCustomerAge(customer.getBirthDate());
        int minimumAge = ratingService.getMinimumAgeByRatingCode(rating.getCode());
        return customerAge >= minimumAge;
    }

    // menghitung sesuai tgl lahir
    private int calculateCustomerAge(Date birthDate) {
        LocalDate birthLocalDate = birthDate.toLocalDate();
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthLocalDate, currentDate).getYears();
    }
}
