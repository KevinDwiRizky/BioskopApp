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
    @NotBlank(message = "Customer ID must not be blank")
    private String customerId;
    @NotBlank(message = "Movie ID must not be blank")
    private String movieId;
    @NotBlank(message = "Seat ID must not be blank")
    private String seatId;
}
