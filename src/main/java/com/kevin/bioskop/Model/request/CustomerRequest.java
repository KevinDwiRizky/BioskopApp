package com.kevin.bioskop.Model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    @NotBlank(message = "Name is mandatory and cannot be blank")
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name must contain only alphabets")
    private String name;
    @NotNull(message = "Birth Date is mandatory and cannot be Null")
    private Date birthDate;
}
