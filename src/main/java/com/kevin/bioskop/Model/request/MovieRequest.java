package com.kevin.bioskop.Model.request;

import com.kevin.bioskop.entity.Rating;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {
    @NotBlank(message = "Name must not be blank")
    private String name;
    @Positive(message = "Duration must be a positive integer")
    private int duration;
    @NotNull(message = "Show date must not be null")
    private Date showDate;
    @Positive(message = "Price must be a positive number")
    private double price;
    @NotBlank(message = "Rating ID must not be blank")
    private String ratingId;
}
