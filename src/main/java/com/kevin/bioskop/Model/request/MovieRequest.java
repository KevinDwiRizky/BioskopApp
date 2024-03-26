package com.kevin.bioskop.Model.request;

import com.kevin.bioskop.entity.Rating;
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
    private String name;
    private int duration;
    private Date showDate;
    private double price;
    private String ratingId;
}
