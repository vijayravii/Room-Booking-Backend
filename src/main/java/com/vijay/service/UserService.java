package com.vijay.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.DTO.UserDTO;
import com.vijay.exception.DuplicateUserNameFoundException;
import com.vijay.exception.UserNotFoundException;
import com.vijay.model.UserEntity;
import com.vijay.repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class UserService {

	private static final Logger logger = LogManager.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;

	public UserEntity createUser(UserDTO userDTO) throws IOException{
		
		UserEntity userEntity = new UserEntity();

		Optional<UserEntity> optional = userRepository.findByUsername(userDTO.getUsername());

		if (optional.isPresent()) {
			logger.info("Optional object : "+ optional);
			throw new DuplicateUserNameFoundException("Duplicate UserName Found");
		} else {
			userEntity.setFullName(userDTO.getFullName());
			userEntity.setMobileNo(userDTO.getMobileNo());
			userEntity.setRole("user");
			userEntity.setEmail(userDTO.getEmail().toLowerCase());
			userEntity.setAddress(userDTO.getAddress());
			userEntity.setUsername(userDTO.getUsername());
			userEntity.setPassword(userDTO.getPassword());
			return userRepository.save(userEntity);
		}
	}

	public List<UserEntity> getUser() {
		return userRepository.findAll();
	}

	public UserEntity updateUser(Long id, UserDTO userDTO) throws IOException {

		UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User is not found for id : " + id));

		Optional<UserEntity> optional = userRepository.findByUsername(userDTO.getUsername());
		
		logger.info("Optional is : "+optional);

		if (optional.isPresent()) {
			throw new DuplicateUserNameFoundException("Duplicate UserName Found");
		} else {
			userEntity.setFullName(userDTO.getFullName());
			userEntity.setMobileNo(userDTO.getMobileNo());
			userEntity.setEmail(userDTO.getEmail());
			userEntity.setAddress(userDTO.getAddress());
			userEntity.setUsername(userDTO.getUsername());
			userEntity.setPassword(userDTO.getPassword());
			return userRepository.save(userEntity);
		}
	}

	public void deleteUser(@Valid Long id) {
		userRepository.deleteById(id);

	}

}
