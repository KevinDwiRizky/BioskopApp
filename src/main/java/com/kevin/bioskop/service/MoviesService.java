package com.kevin.bioskop.service;

import com.kevin.bioskop.Model.request.MovieRequest;
import com.kevin.bioskop.entity.Movies;

import java.sql.Date;
import java.util.List;

public interface MoviesService {
    Movies createMovies(MovieRequest movieRequest);
    List<Movies> findMovies(String name, Integer duration, Date showDate, Double price, String ratingId);
    Movies getMoviesById(String id);
}
