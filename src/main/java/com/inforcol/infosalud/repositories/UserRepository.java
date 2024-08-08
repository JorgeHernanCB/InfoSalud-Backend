package com.inforcol.infosalud.repositories;


import com.inforcol.infosalud.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <Users,Long> {

}
