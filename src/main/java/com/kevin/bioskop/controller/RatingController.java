package com.kevin.bioskop.controller;

import com.kevin.bioskop.Model.request.RatingRequest;
import com.kevin.bioskop.Model.request.RatingRequest;
import com.kevin.bioskop.Model.response.PagingResponse;
import com.kevin.bioskop.Model.response.WebResponse;
import com.kevin.bioskop.entity.Rating;
import com.kevin.bioskop.entity.Rating;
import com.kevin.bioskop.service.RatingService;
import com.kevin.bioskop.service.RatingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<?> createRating(@Valid @RequestBody RatingRequest ratingRequest) {
        Rating newRating = ratingService.createRating(ratingRequest);
        WebResponse<Rating> response = WebResponse.<Rating>builder()
                .status(HttpStatus.CREATED.getReasonPhrase())
                .message("Success add data")
                .data(newRating)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> getAllRating(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ){
        Page<Rating> ratingList = ratingService.getAllRating(page, size);

        PagingResponse pagingResponse = PagingResponse.builder()
                .page(page).size(size)
                .totalPages(ratingList.getTotalPages())
                .totalElement(ratingList.getTotalElements())
                .build();

        WebResponse<List<Rating>> response = WebResponse.<List<Rating>>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Get List data")
                .paging(pagingResponse)
                .data(ratingList.getContent())
                .build();
        return ResponseEntity.ok(response);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getRatingById(@PathVariable String id) {
        Rating findrating = ratingService.getRatingById(id);
        WebResponse<Rating> response = WebResponse.<Rating>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Get By Id ")
                .data(findrating)
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteRatingById(@PathVariable String id){
        ratingService.deleteRatingById(id);
        WebResponse<String> response = WebResponse.<String>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Delete Rating By Id ")
                .data("OK")
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<?> updateRatingById(@RequestBody Rating rating){
        Rating updateRating = ratingService.updateRating(rating);
        WebResponse<Rating> response = WebResponse.<Rating>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Update By Id ")
                .data(updateRating)
                .build();
        return ResponseEntity.ok(response);
    }


}
