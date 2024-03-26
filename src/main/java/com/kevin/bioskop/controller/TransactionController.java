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
@RequestMapping("/purchase-tickets")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> buyTicket(@Valid @RequestBody TransactionRequest transactionRequest) {
        try {
            Transaction transaction = transactionService.buyTicket(transactionRequest);
            return new ResponseEntity<>(transaction, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}


