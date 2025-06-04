package com.example.server_side.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.server_side.Converters.UserConverter;
import com.example.server_side.DTO.UserDTO;
import com.example.server_side.Models.User;
import com.example.server_side.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userConverter.toUserDTOList(users);
    }

    public UserDTO getUserByEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password).get();
        return userConverter.toUserDTO(user);
    }

    public UserDTO addUser(UserDTO userDTO) {
        User user = userConverter.toUser(userDTO);
        if (!userRepository.existsByEmail(user.getEmail())) {
            user = userRepository.save(user);
            return userConverter.toUserDTO(user);
        }
        return null;
    }
}
