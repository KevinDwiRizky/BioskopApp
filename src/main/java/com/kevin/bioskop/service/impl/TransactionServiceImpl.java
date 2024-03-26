package com.kevin.bioskop.service.impl;

import com.kevin.bioskop.Model.request.TransactionRequest;
import com.kevin.bioskop.entity.Customer;
import com.kevin.bioskop.entity.Movies;
import com.kevin.bioskop.entity.Seats;
import com.kevin.bioskop.entity.Transaction;
import com.kevin.bioskop.repository.TransactionRepository;
import com.kevin.bioskop.service.CustomerService;
import com.kevin.bioskop.service.MoviesService;
import com.kevin.bioskop.service.SeatsService;
import com.kevin.bioskop.service.TransactionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MoviesService moviesService;
    @Autowired
    private SeatsService seatsService;

    @Override
    @Transactional
    public Transaction buyTicket(TransactionRequest transactionRequest) {

        Customer customer = customerService.getCustomerById(transactionRequest.getCustomerId());

        Movies movie = moviesService.getMoviesById(transactionRequest.getMovieId());

        if (!customerService.isCustomerAllowedToWatch(customer, movie.getRating())) {
            throw new RuntimeException("Tidak dizinkan untuk menonton film");
        }

        Seats seat = seatsService.getSeatByNumber(transactionRequest.getSeatId());
        if (!seatsService.isSeatAvailable(seat)) {
            throw new RuntimeException("Selected seat is not available.");
        }

        seatsService.decreaseSeatStock(seat);

        Transaction transaction = Transaction.builder()
                .customer(customer)
                .movie(movie)
                .seat(seat)
                .transactionDate(new Date())
                .build();


        return transactionRepository.save(transaction);
    }
}


