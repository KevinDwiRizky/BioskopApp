package com.kevin.bioskop.service;

import com.kevin.bioskop.Model.request.SeatsRequest;
import com.kevin.bioskop.Model.request.TheaterRequest;
import com.kevin.bioskop.entity.Seats;
import com.kevin.bioskop.entity.Theater;
import org.springframework.data.domain.Page;

public interface SeatsService {
    Seats addSeats(SeatsRequest seatsRequest);
    Page<Seats> getAllSeats(Integer page, Integer size);
}
