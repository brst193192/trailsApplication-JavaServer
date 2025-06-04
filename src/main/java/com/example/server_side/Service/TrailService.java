package com.example.server_side.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.server_side.Converters.TrailConverter;
import com.example.server_side.DTO.TrailDTO;
import com.example.server_side.Models.Trail;
import com.example.server_side.Repository.FavoriteRepository;
import com.example.server_side.Repository.TrailRepository;

@Service
public class TrailService {

    @Autowired
    private TrailRepository trailRepository;

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private TrailConverter trailConverter;

    public List<TrailDTO> getAll() {
        List<TrailDTO> trails = trailRepository.findAll().stream()
                .map(t -> trailConverter.toTrailDTO(t)).collect(Collectors.toList());
        return trails;
    }

    public TrailDTO addTrail(TrailDTO trailDTO) {
        Trail trail = trailConverter.toTrail(trailDTO);
        System.out.println("id = " + trail.getId());
        try {
            return trailConverter.toTrailDTO(trailRepository.save(trail));
        } catch (Exception e) {
            System.out.println("----------------- ERROR: ------------------\n" + e.getMessage());
            return null;
        }
    }

    public boolean updateTrail(TrailDTO trailDTO) {
        Trail trail = trailConverter.toTrail(trailDTO);
        if (trailRepository.existsById(trail.getId())) {
            trailRepository.save(trail);
            return true;
        }
        return false;
    }

    public TrailDTO deleteTrail(int trailId) {
        favoriteRepository.deleteAll(favoriteRepository.findByTrailId(trailId));
        Trail trail = trailRepository.findById(trailId).get();
        trailRepository.deleteById(trail.getId());
        return trailConverter.toTrailDTO(trail);
    }
}
