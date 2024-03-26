package com.kevin.bioskop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonIgnore
    @JsonManagedReference
    private List<Seats> seats;

}

