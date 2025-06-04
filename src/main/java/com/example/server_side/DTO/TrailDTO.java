package com.example.server_side.DTO;

import lombok.Data;

@Data
public class TrailDTO {
    private int id;
    private String name;
    private String src;
    private String description;
    private String moreInfo;
    private String howToCome;
    private String waysInTrail;
    private int userId;
}
