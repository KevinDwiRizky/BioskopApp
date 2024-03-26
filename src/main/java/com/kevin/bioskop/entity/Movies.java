package com.kevin.bioskop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_movie")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private int duration;
    private Date showDate;
    private double price;

    @ManyToOne
    @JoinColumn(name = "rating_id")
    private Rating rating;

}
