package com.kevin.bioskop.controller;

import com.kevin.bioskop.Model.request.RatingRequest;
import com.kevin.bioskop.Model.request.TheaterRequest;
import com.kevin.bioskop.Model.response.PagingResponse;
import com.kevin.bioskop.Model.response.WebResponse;
import com.kevin.bioskop.entity.Rating;
import com.kevin.bioskop.entity.Theater;
import com.kevin.bioskop.service.TheaterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;

    @PostMapping
    public ResponseEntity<?> createTheater(@Valid @RequestBody TheaterRequest theaterRequest) {
        Theater newTheater = theaterService.addTheater(theaterRequest);
        WebResponse<Theater> response = WebResponse.<Theater>builder()
                .status(HttpStatus.CREATED.getReasonPhrase())
                .message("Success add data")
                .data(newTheater)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> getAllRating(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ){
        Page<Theater> theaterList = theaterService.getAllRating(page, size);

        PagingResponse pagingResponse = PagingResponse.builder()
                .page(page).size(size)
                .totalPages(theaterList.getTotalPages())
                .totalElement(theaterList.getTotalElements())
                .build();

        WebResponse<List<Theater>> response = WebResponse.<List<Theater>>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Get List data")
                .paging(pagingResponse)
                .data(theaterList.getContent())
                .build();
        return ResponseEntity.ok(response);
    }

}
