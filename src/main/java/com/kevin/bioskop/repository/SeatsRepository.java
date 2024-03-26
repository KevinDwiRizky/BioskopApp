package com.kevin.bioskop.repository;

import com.kevin.bioskop.entity.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatsRepository extends JpaRepository<Seats, String > {
}
