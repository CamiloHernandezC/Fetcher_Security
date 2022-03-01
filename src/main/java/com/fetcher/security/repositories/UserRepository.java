package com.fetcher.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fetcher.security.entities.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUsername(String username);

}
