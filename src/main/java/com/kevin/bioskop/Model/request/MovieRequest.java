package com.kevin.bioskop.Model.request;

import com.kevin.bioskop.entity.Rating;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
<<<<<<< HEAD
=======
import jakarta.validation.constraints.PastOrPresent;
>>>>>>> 61cd971e1f7fae62198f8528a8fc25621f6f0b23
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
<<<<<<< HEAD
    @NotBlank(message = "Name must not be blank")
    private String name;
    @Positive(message = "Duration must be a positive integer")
    private int duration;
    @NotNull(message = "Show date must not be null")
    private Date showDate;
    @Positive(message = "Price must be a positive number")
    private double price;
    @NotBlank(message = "Rating ID must not be blank")
=======
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Positive(message = "Duration must be a positive number")
    private int duration;

    @NotNull(message = "Show date cannot be null")
    @PastOrPresent(message = "Show date must be in the past or present")
    private Date showDate;

    @Positive(message = "Price must be a positive number")
    private double price;

    @NotBlank(message = "Rating ID cannot be blank")
>>>>>>> 61cd971e1f7fae62198f8528a8fc25621f6f0b23
    private String ratingId;
}
