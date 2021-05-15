package br.com.autosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autosoft.dtos.UserDTO;
import br.com.autosoft.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{


}
