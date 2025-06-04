package com.example.server_side.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.server_side.Models.Trail;

@Repository
public interface TrailRepository extends JpaRepository<Trail, Integer> {
    
}
