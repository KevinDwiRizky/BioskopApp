package com.kevin.bioskop.repository;

import com.kevin.bioskop.entity.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatsRepository extends JpaRepository<Seats, String > {
    Optional<Seats> findBySeatNumber(String seatNumber);
}
