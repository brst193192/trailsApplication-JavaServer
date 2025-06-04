package com.example.server_side.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
}
