package com.kevin.bioskop.service;

import com.kevin.bioskop.Model.request.SeatsRequest;
import com.kevin.bioskop.entity.Seats;
import org.springframework.data.domain.Page;

public interface SeatsService {
    Seats addSeats(SeatsRequest seatsRequest);
    Page<Seats> getAllSeats(Integer page, Integer size);

    Seats getSeatByNumber(String id);

    boolean isSeatAvailable(Seats seat);

    void decreaseSeatStock(Seats seat);
}
