package com.kevin.bioskop.controller;

import com.kevin.bioskop.Model.request.TransactionRequest;
import com.kevin.bioskop.entity.Transaction;
import com.kevin.bioskop.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
<<<<<<< HEAD
@RequestMapping("/transactions")
=======
@RequestMapping("/purchase-tickets")
>>>>>>> 61cd971e1f7fae62198f8528a8fc25621f6f0b23
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

<<<<<<< HEAD
    @PostMapping("/buy-ticket")
    public ResponseEntity<Transaction> buyTicket(@Valid @RequestBody TransactionRequest transactionRequest) {
=======
    @PostMapping
    public ResponseEntity<?> buyTicket(@Valid @RequestBody TransactionRequest transactionRequest) {
>>>>>>> 61cd971e1f7fae62198f8528a8fc25621f6f0b23
        try {
            Transaction transaction = transactionService.buyTicket(transactionRequest);
            return new ResponseEntity<>(transaction, HttpStatus.CREATED);
        } catch (RuntimeException e) {
<<<<<<< HEAD
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
=======
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
>>>>>>> 61cd971e1f7fae62198f8528a8fc25621f6f0b23
        }
    }
}

<<<<<<< HEAD
=======

>>>>>>> 61cd971e1f7fae62198f8528a8fc25621f6f0b23
