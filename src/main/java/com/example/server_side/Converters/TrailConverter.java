package com.example.server_side.Converters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.server_side.DTO.TrailDTO;
import com.example.server_side.Models.Trail;
import com.example.server_side.Models.User;
import com.example.server_side.Repository.UserRepository;

public class TrailConverter {

    @Autowired
    private UserRepository userRepository;

    public TrailDTO toTrailDTO(Trail trail) {
        TrailDTO trailDTO = new TrailDTO();
        trailDTO.setId(trail.getId());
        trailDTO.setName(trail.getName());
        trailDTO.setSrc(trail.getSrc());
        trailDTO.setDescription(trail.getDescription());
        trailDTO.setMoreInfo(trail.getMoreInfo());
        trailDTO.setHowToCome(trail.getHowToCome());
        trailDTO.setWaysInTrail(trail.getWaysInTrail());
        trailDTO.setUserId(trail.getUser().getId());
        return trailDTO;
    }

    public Trail toTrail(TrailDTO trailDTO) {
        Trail trail = new Trail();
        trail.setId(trailDTO.getId());
        trail.setName(trailDTO.getName());
        trail.setSrc(trailDTO.getSrc());
        trail.setDescription(trailDTO.getDescription());
        trail.setMoreInfo(trailDTO.getMoreInfo());
        trail.setHowToCome(trailDTO.getHowToCome());
        trail.setWaysInTrail(trailDTO.getWaysInTrail());
        User user = userRepository.findById(trailDTO.getUserId()).get();
        trail.setUser(user);
        return trail;
    }

    public List<TrailDTO> ManyToTrailDTO(List<Trail> trails) {
        List<TrailDTO> trailDTOs = trails.stream()
                .map(t -> toTrailDTO(t)).toList();
        return trailDTOs;
    }
}
