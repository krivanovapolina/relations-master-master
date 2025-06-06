package com.example.relations.services;

import com.example.relations.DTO.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO create(UserDTO user);
    UserDTO findById(Long id);
    List<UserDTO> getAll();
    UserDTO update(Long id, UserDTO user);
    void delete(Long id);

}
