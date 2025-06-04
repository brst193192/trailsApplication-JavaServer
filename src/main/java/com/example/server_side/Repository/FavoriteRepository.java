package com.example.server_side.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.server_side.Models.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    Favorite getByUserIdAndTrailId(int userId, int trailId);
    List<Favorite> findByTrailId(int trailId);
}

