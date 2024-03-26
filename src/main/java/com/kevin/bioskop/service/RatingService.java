package com.kevin.bioskop.service;

import com.kevin.bioskop.Model.request.RatingRequest;
import com.kevin.bioskop.entity.Rating;
import org.springframework.data.domain.Page;

public interface RatingService {

    Rating createRating(RatingRequest ratingRequest);

    Page<Rating> getAllRating(Integer page, Integer size);

    Rating getRatingById(String id);

    Rating updateRating(Rating rating);

    void  deleteRatingById(String id);

}
