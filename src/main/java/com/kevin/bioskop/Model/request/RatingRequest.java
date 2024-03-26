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
public class RatingRequest {

    @NotBlank(message = "Code cannot be blank")
    private String code;
    @NotBlank(message = "Description cannot be blank")
    private String description;
}
