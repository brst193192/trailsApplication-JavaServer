package com.example.server_side.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.server_side.DTO.TrailDTO;
import com.example.server_side.Service.FavoriteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("/favorites")
@RestController
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/getMyFavorites/{id}")
    public ResponseEntity<List<TrailDTO>> getFavorites(@PathVariable int id) {
        System.err.println("------------------------getMyFavorites id: " + id);
        return ResponseEntity.ok(favoriteService.getByUserId(id));
    }

    @GetMapping("/hotTrails")
    public ResponseEntity<List<TrailDTO>> getHotTrails() {
        return ResponseEntity.ok(favoriteService.getHot());
    }

    @PutMapping("changeStatus/{userId}/{trailId}")
    public void changeStatus(@PathVariable int userId, @PathVariable int trailId) {
        System.out.println("------------------------changeStatus userId: " + userId + " trailId: " + trailId);
        favoriteService.changeStatus(userId, trailId);
    }
}
