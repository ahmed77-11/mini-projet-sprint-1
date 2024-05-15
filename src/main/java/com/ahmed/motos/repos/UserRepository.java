package com.ahmed.motos.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.motos.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);

}
