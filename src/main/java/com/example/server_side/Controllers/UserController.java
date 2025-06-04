package com.example.server_side.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.server_side.DTO.UserDTO;
import com.example.server_side.Service.UserService;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAll() {
        List<UserDTO> users=userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<UserDTO> login(@PathVariable String email, @PathVariable String password) {
        return ResponseEntity.ok(userService.getUserByEmailAndPassword(email, password));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> Register(@RequestBody UserDTO user) {
        return ResponseEntity.ok(userService.addUser(user));
    }
}
