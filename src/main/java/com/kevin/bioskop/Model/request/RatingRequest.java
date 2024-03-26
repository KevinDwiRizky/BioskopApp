package com.kevin.bioskop.Model.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RatingRequest {
    @NotBlank(message = "Code must not be blank")
    @Size(max = 10, message = "Code must be less than or equal to 10 characters")
    private String code;
    @NotBlank(message = "Description must not be blank")
    @Size(max = 255, message = "Description must be less than or equal to 255 characters")
    private String description;
}
