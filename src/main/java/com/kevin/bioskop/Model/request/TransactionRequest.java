package com.kevin.bioskop.Model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
<<<<<<< HEAD
    @NotBlank(message = "Customer ID must not be blank")
    private String customerId;
    @NotBlank(message = "Movie ID must not be blank")
    private String movieId;
    @NotBlank(message = "Seat ID must not be blank")
=======
    @NotBlank(message = "Customer ID cannot be blank")
    private String customerId;

    @NotBlank(message = "Movie ID cannot be blank")
    private String movieId;

    @NotBlank(message = "Seat ID cannot be blank")
>>>>>>> 61cd971e1f7fae62198f8528a8fc25621f6f0b23
    private String seatId;
}
