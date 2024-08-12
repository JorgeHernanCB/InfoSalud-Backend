package com.inforcol.infosalud.services;

import com.inforcol.infosalud.entities.DTO.UserDto;
import com.inforcol.infosalud.entities.Users;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();
    UserDto findById(Long id);
    UserDto save(UserDto users);
    UserDto updateUser(Long id, UserDto users);
    String deleteUser(Long id);

}
