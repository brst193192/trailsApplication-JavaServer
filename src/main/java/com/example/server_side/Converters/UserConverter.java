package com.example.server_side.Converters;

import java.util.List;

import com.example.server_side.DTO.UserDTO;
import com.example.server_side.Models.User;

public class UserConverter {

    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId((user.getId()));
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public List<UserDTO> toUserDTOList(List<User> users) {
        List<UserDTO> usersDTO = users.stream().map(u->toUserDTO(u)).toList();
        return usersDTO;
    }

    public User toUser(UserDTO userDTO) {
        User user = new User();
        user.setId((userDTO.getId()));
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;
    }
}
