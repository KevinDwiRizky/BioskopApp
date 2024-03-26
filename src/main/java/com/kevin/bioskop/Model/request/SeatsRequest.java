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
public class SeatsRequest {
    @NotBlank(message = "Seat number must not be blank")
    private String seatNumber;
    @NotBlank(message = "Theater ID must not be blank")
    private String theaterId;
}
