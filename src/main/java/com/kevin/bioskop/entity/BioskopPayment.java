package com.kevin.bioskop.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "t_customer")
public class BioskopPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false,updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a", timezone = "Asia/Jakarta")
    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @PrePersist
    protected void onCreate(){
        date = new Date();
    }

}
