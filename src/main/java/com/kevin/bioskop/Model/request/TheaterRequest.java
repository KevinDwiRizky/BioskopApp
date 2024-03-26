package com.kevin.bioskop.Model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheaterRequest {
    @NotBlank(message = "Theater number must not be blank")
    @Size(min = 1, max = 50, message = "Theater number length must be between 1 and 50 characters")
    private String theaterNumber;

    @NotNull(message = "Stock must not be null")
    @PositiveOrZero(message = "Stock must be a positive number or zero")
    private int stock;
}
