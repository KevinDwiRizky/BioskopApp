package com.kevin.bioskop.repository;

import com.kevin.bioskop.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, String > {
}
