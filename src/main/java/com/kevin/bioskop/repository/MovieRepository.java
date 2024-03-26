package com.kevin.bioskop.repository;

import com.kevin.bioskop.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movies , String> , JpaSpecificationExecutor<Movies> {

}
