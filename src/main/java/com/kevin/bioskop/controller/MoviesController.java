package com.kevin.bioskop.controller;

import com.kevin.bioskop.Model.request.MovieRequest;
import com.kevin.bioskop.Model.response.WebResponse;
import com.kevin.bioskop.entity.Movies;
import com.kevin.bioskop.service.MoviesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    private MoviesService moviesService;

    @PostMapping
    public ResponseEntity<?> createMovies(@Valid @RequestBody MovieRequest movieRequest) {
        Movies createdMovie = moviesService.createMovies(movieRequest);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findMovies(@RequestParam(required = false) String name,
                                                   @RequestParam(required = false) Integer duration,
                                                   @RequestParam(required = false) Date showDate,
                                                   @RequestParam(required = false) Double price,
                                                   @RequestParam(required = false) String ratingId) {
        List<Movies> foundMovies = moviesService.findMovies(name, duration, showDate, price, ratingId);
        return new ResponseEntity<>(foundMovies, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateMoviesById(@RequestBody Movies movies){
        Movies updateMovies = moviesService.updateMovies(movies);
        WebResponse<Movies> response = WebResponse.<Movies>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Update Nasabah By Id ")
                .data(updateMovies)
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteMoviesById(@PathVariable String id){
        moviesService.deleteMoviesById(id);
        WebResponse<String> response = WebResponse.<String>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Delete Movies By Id ")
                .data("OK")
                .build();
        return ResponseEntity.ok(response);
    }


}
