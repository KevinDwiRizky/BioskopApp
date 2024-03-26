package com.kevin.bioskop.service.impl;

import com.kevin.bioskop.Model.request.MovieRequest;
import com.kevin.bioskop.entity.*;
import com.kevin.bioskop.repository.MovieRepository;
import com.kevin.bioskop.repository.RatingRepository;
import com.kevin.bioskop.service.MoviesService;
import com.kevin.bioskop.service.RatingService;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private RatingService ratingService;

    @Override
    public Movies createMovies(MovieRequest movieRequest) {
        Rating rating = ratingRepository.findById(movieRequest.getRatingId())
                .orElseThrow(() -> new RuntimeException("Rating not found"));

        Movies newMovies = Movies.builder()
                .name(movieRequest.getName())
                .duration(movieRequest.getDuration())
                .showDate(movieRequest.getShowDate())
                .price(movieRequest.getPrice())
                .rating(rating)
                .build();

        return movieRepository.save(newMovies);
    }

    @Override
    public Movies getMoviesById(String id) {
        Optional<Movies> optionalMovies = movieRepository.findById(id);
        if (optionalMovies.isPresent()) return optionalMovies.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie with id : " + id + " Not Found");

    }

    @Override
    public Movies updateMovies(Movies movies) {
        this.getMoviesById(movies.getId());
        return movieRepository.save(movies);
    }

    @Override
    public void deleteMoviesById(String id) {
        this.getMoviesById(id);
        movieRepository.deleteById(id);
    }


    @Override
    public List<Movies> findMovies(String name, Integer duration, Date showDate, Double price, String ratingId) {
        // Buat spesifikasi (Specification) untuk kueri dinamis
        Specification<Movies> spec = (root, query, criteriaBuilder) -> {
            // Inisialisasi list of predicates
            List<Predicate> predicates = new ArrayList<>();

            // Tambahkan predikat jika nilai parameter tidak null atau kosong
            if (name != null && !name.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }
            if (duration != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("duration"), duration));
            }
            if (showDate != null) {
                predicates.add(criteriaBuilder.equal(root.get("showDate"), showDate));
            }
            if (price != null) {
                predicates.add(criteriaBuilder.equal(root.get("price"), price));
            }
            if (ratingId != null) {
                predicates.add(criteriaBuilder.equal(root.get("rating").get("id"), ratingId));
            }

            // Gabungkan semua predikat dengan operator AND
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        // Dapatkan daftar Movies berdasarkan spesifikasi
        return movieRepository.findAll(spec);
    }



}


