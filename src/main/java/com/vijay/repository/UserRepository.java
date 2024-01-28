package com.vijay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

	Optional<UserEntity> findByUsername(String username);

}
