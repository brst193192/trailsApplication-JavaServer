package com.example.server_side.DTO;

import lombok.Data;

@Data
public class FavoriteDTO {
    private int id;
    private int userId;
    private int trailId;
    private TrailDTO trail;
}
