package com.example.AuthService.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AuthService.Entity.Users;

public interface UserRepository extends JpaRepository <Users, Long>  {

	Optional<Users> findByUsername(String username);

}
