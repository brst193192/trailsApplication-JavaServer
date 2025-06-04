package com.example.server_side.Converters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.server_side.DTO.FavoriteDTO;
import com.example.server_side.Models.Favorite;
import com.example.server_side.Repository.TrailRepository;
import com.example.server_side.Repository.UserRepository;

public class FavoriteConverter {

    @Autowired
    private TrailRepository trailRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrailConverter trailConverter;

    public FavoriteDTO toFavoriteDTO(Favorite favorite) {
        FavoriteDTO favoriteDTO = new FavoriteDTO();
        favoriteDTO.setId(favorite.getId());
        favoriteDTO.setTrail(trailConverter.toTrailDTO(trailRepository.findById(favorite.getTrail().getId()).get()));
        favoriteDTO.setTrailId(favorite.getTrail().getId());
        favoriteDTO.setUserId(favorite.getUser().getId());
        return favoriteDTO;
    }

    public List<FavoriteDTO> ManyToFavoriteDTO(List<Favorite> favorite) {
        List<FavoriteDTO> favoriteDTOs = favorite.stream()
                .map(f -> toFavoriteDTO(f)).toList();
        return favoriteDTOs;
    }

    public Favorite toFavorite(FavoriteDTO favoriteDTO) {
        Favorite favorite = new Favorite();
        favorite.setId(favoriteDTO.getId());
        favorite.setTrail(trailRepository.findById(favoriteDTO.getTrailId()).get());
        favorite.setUser(userRepository.findById(favoriteDTO.getUserId()).get());
        return favorite;
    }
}
