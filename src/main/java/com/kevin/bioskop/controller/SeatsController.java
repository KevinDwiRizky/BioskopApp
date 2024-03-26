package com.kevin.bioskop.controller;

import com.kevin.bioskop.Model.request.SeatsRequest;
import com.kevin.bioskop.Model.response.PagingResponse;
import com.kevin.bioskop.Model.response.WebResponse;
import com.kevin.bioskop.entity.Seats;
import com.kevin.bioskop.entity.Theater;
import com.kevin.bioskop.service.SeatsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatsController {

    private final SeatsService seatsService;

    @Autowired
    public SeatsController(SeatsService seatsService) {
        this.seatsService = seatsService;
    }

    @PostMapping
    public ResponseEntity<Seats> addSeats(@Valid @RequestBody SeatsRequest seatsRequest) {
        Seats newSeat = seatsService.addSeats(seatsRequest);
        return new ResponseEntity<>(newSeat, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllRating(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ){
        Page<Seats> seatsList = seatsService.getAllSeats(page, size);

        PagingResponse pagingResponse = PagingResponse.builder()
                .page(page).size(size)
                .totalPages(seatsList.getTotalPages())
                .totalElement(seatsList.getTotalElements())
                .build();

        WebResponse<List<Seats>> response = WebResponse.<List<Seats>>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Get List data")
                .paging(pagingResponse)
                .data(seatsList.getContent())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{seatNumber}")
    public ResponseEntity<Seats> getSeatBySeatNumber(@PathVariable String seatNumber) {
        try {
            Seats seat = seatsService.getSeatByNumber(seatNumber);
            return new ResponseEntity<>(seat, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
