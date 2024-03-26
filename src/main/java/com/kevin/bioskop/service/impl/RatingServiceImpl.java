package com.kevin.bioskop.service.impl;

import com.kevin.bioskop.Model.request.RatingRequest;
import com.kevin.bioskop.entity.Customer;
import com.kevin.bioskop.entity.Rating;
import com.kevin.bioskop.repository.RatingRepository;
import com.kevin.bioskop.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating createRating(RatingRequest ratingRequest) {
        Rating newRating = Rating.builder()
                .code(ratingRequest.getCode())
                .description(ratingRequest.getDescription())
                .build();

        return ratingRepository.save(newRating);
    }

    @Override
    public Page<Rating> getAllRating(Integer page, Integer size) {
        if (page <=0) {
            page = 1;
        }
        Pageable pageable = PageRequest.of(page-1, size);
        return ratingRepository.findAll(pageable);
    }

    @Override
    public Rating getRatingById(String id) {
        Optional<Rating> optionalRating = ratingRepository.findById(id);
        if (optionalRating.isPresent()) return optionalRating.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rating with id : " + id + " Not Found");
    }

    @Override
    public Rating updateRating(Rating rating) {
        this.getRatingById(rating.getId());
        return ratingRepository.save(rating);
    }

    @Override
    public void deleteRatingById(String id) {
        this.getRatingById(id);
        ratingRepository.deleteById(id);
    }

    @Override
    public int getMinimumAgeByRatingCode(String ratingCode) {
        if ("A".equals(ratingCode)) {
            return 0;
        } else if ("BO".equals(ratingCode)) {
            return 13;
        } else if ("R".equals(ratingCode)) {
            return 18;
        } else if ("D".equals(ratingCode)) {
            return 21;
        } else {
            throw new IllegalArgumentException("Invalid rating code: " + ratingCode);
        }
    }
}
