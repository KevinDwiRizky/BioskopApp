package com.kevin.bioskop.service.impl;

import com.kevin.bioskop.Model.request.TheaterRequest;
import com.kevin.bioskop.entity.Rating;
import com.kevin.bioskop.entity.Theater;
import com.kevin.bioskop.repository.TheaterRepository;
import com.kevin.bioskop.service.TheaterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;
    @Override
    public Theater addTheater( TheaterRequest theaterRequest) {

        Theater newTheater = Theater.builder()
                .theaterNumber(theaterRequest.getTheaterNumber())
                .stock(0)
                .build();

        return theaterRepository.save(newTheater);
    }

    @Override
    public Page<Theater> getAllRating(Integer page, Integer size) {
            if (page <=0) {
                page = 1;
            }
            Pageable pageable = PageRequest.of(page-1, size);
            return theaterRepository.findAll(pageable);
    }
}
