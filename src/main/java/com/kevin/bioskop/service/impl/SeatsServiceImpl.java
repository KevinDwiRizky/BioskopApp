package com.kevin.bioskop.service.impl;

import com.kevin.bioskop.Model.request.SeatsRequest;
import com.kevin.bioskop.Model.request.TheaterRequest;
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
import org.springframework.stereotype.Service;

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
}
