package com.kevin.bioskop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "t_theater")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String theaterNumber;
    private int stock;


    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<Seats> seats;

}

