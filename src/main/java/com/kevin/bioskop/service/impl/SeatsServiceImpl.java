package com.kevin.bioskop.service.impl;

import com.kevin.bioskop.Model.request.SeatsRequest;
import com.kevin.bioskop.Model.request.TheaterRequest;
import com.kevin.bioskop.entity.Customer;
import com.kevin.bioskop.entity.Seats;
import com.kevin.bioskop.entity.Theater;
import com.kevin.bioskop.repository.SeatsRepository;
import com.kevin.bioskop.repository.TheaterRepository;
import com.kevin.bioskop.service.SeatsService;
import com.kevin.bioskop.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class SeatsServiceImpl implements SeatsService {

    @Autowired
    private SeatsRepository seatsRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    public Seats addSeats(SeatsRequest seatsRequest) {

        Theater theater = theaterRepository.findById(seatsRequest.getTheaterId())
                .orElseThrow(() -> new RuntimeException("Theater not found"));

        Seats newSeat = Seats.builder()
                .seatNumber(seatsRequest.getSeatNumber())
                .theater(theater)
                .build();

        seatsRepository.save(newSeat);

        int updatedStock = theater.getStock() + 1;
        theater.setStock(updatedStock);

        theaterRepository.save(theater);

        return newSeat;
    }

    @Override
    public Page<Seats> getAllSeats(Integer page, Integer size) {
        if (page <=0) {
            page = 1;
        }
        Pageable pageable = PageRequest.of(page-1, size);
        return seatsRepository.findAll(pageable);
    }

    @Override
    public Seats getSeatByNumber(String seatNumber) {
        Optional<Seats> optionalSeat = seatsRepository.findBySeatNumber(seatNumber);
        if (optionalSeat.isPresent()) return optionalSeat.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Seats with id : " + seatNumber + " Not Found");
    }

    @Override
    public boolean isSeatAvailable(Seats seat) {
        Theater theater = seat.getTheater();
        int currentStock = theater.getStock();
        return currentStock > 0;
    }

    @Override
    public void decreaseSeatStock(Seats seat) {
        Theater theater = seat.getTheater();
        int currentStock = theater.getStock();
        if (currentStock > 0) {
            theater.setStock(currentStock - 1);
            theaterRepository.save(theater);
        } else {
            throw new RuntimeException("No available stock in the theater.");
        }
    }
}
