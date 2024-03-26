package com.kevin.bioskop.service;

import com.kevin.bioskop.Model.request.TransactionRequest;
import com.kevin.bioskop.entity.Transaction;

public interface TransactionService {
    Transaction buyTicket(TransactionRequest transactionRequest);
}
