package com.inforcol.infosalud.repositories;

import org.springframework.data.repository.CrudRepository;
import com.inforcol.infosalud.entities.UserEntity;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityByUsername(String username);

}
