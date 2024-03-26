package com.kevin.bioskop.Model.request;

<<<<<<< HEAD
import jakarta.validation.constraints.*;
=======
import jakarta.validation.constraints.NotBlank;
>>>>>>> 61cd971e1f7fae62198f8528a8fc25621f6f0b23
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RatingRequest {
<<<<<<< HEAD
    @NotBlank(message = "Code must not be blank")
    @Size(max = 10, message = "Code must be less than or equal to 10 characters")
    private String code;
    @NotBlank(message = "Description must not be blank")
    @Size(max = 255, message = "Description must be less than or equal to 255 characters")
=======
    @NotBlank(message = "Code cannot be blank")
    private String code;
    @NotBlank(message = "Description cannot be blank")
>>>>>>> 61cd971e1f7fae62198f8528a8fc25621f6f0b23
    private String description;
}
