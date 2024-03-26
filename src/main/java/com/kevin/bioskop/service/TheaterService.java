package com.kevin.bioskop.service;

import com.kevin.bioskop.Model.request.TheaterRequest;
import com.kevin.bioskop.entity.Rating;
import com.kevin.bioskop.entity.Theater;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TheaterService {
    public Theater addTheater(TheaterRequest theaterRequest);
    Page<Theater> getAllRating(Integer page, Integer size);

}
