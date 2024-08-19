package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.AuthUser;

public interface AuthenticationRepository extends JpaRepository<AuthUser, Long> {
	
	Optional<AuthUser> findByEmail(String email);

}
