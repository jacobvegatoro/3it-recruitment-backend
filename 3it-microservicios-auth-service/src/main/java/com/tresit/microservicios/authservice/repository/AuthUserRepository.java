package com.tresit.microservicios.authservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tresit.microservicios.authservice.entity.AuthUser;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Integer>  {

	Optional<AuthUser> findByUserName(String username);
	
}