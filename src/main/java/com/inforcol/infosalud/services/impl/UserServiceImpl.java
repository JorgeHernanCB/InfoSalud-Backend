package com.inforcol.infosalud.services.impl;

import com.inforcol.infosalud.controllers.HolaMundoController;
import com.inforcol.infosalud.entities.DTO.UserDto;
import com.inforcol.infosalud.entities.Users;
import com.inforcol.infosalud.exceptions.UserNotFoundException;
import com.inforcol.infosalud.repositories.UserRepository;
import com.inforcol.infosalud.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(HolaMundoController.class);

    @Override
    public List<UserDto> findAll() {
        return this.userRepository.findAll().stream().map(entity -> this.modelMapper.map(entity, UserDto.class)).toList();
    }

    @Override
    public UserDto findById(Long id) {
        Users userEntity = this.userRepository.findById(id).orElseGet(() -> new Users());
        return this.modelMapper.map(userEntity, UserDto.class);
    }

    @Override
    public UserDto save(UserDto clubDTO) {
        Users userEntity = this.modelMapper.map(clubDTO, Users.class);
        Users userSaved = this.userRepository.save(userEntity);
        return this.modelMapper.map(userSaved, UserDto.class);
    }

    @Override
    public UserDto updateUser(Long id, UserDto newUser) {

        Users currentUserEntity = this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuario con id " + id + " no existe."));

        currentUserEntity.setName(newUser.getName());
        currentUserEntity.setAge(newUser.getAge());

        Users userUpdated = this.userRepository.save(currentUserEntity);

        return this.modelMapper.map(userUpdated, UserDto.class);
    }

    @Override
    public String deleteUser(Long id) {

        Users currentClubEntity = this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuario con id " + id + " no existe."));

        this.userRepository.delete(currentClubEntity);

        return "Usuario eliminado correctamente.";
    }

}
