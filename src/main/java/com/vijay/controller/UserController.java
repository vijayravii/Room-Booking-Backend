package com.vijay.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.DTO.UserDTO;
import com.vijay.model.UserEntity;
import com.vijay.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("admin")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("user")
	public UserEntity createUser(@RequestBody UserDTO userDTO) throws IOException {
		return userService.createUser(userDTO);
	}
	
	@GetMapping("user")
	public List<UserEntity> getUser() {
		return userService.getUser();
	}
	
	@PutMapping("user/{id}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) throws IOException {
		UserEntity updateUser = userService.updateUser(id, userDTO); 
		return ResponseEntity.status(HttpStatus.OK).body(updateUser);
	}

	@DeleteMapping("user/{id}")
	public String deleteUser(@Valid @PathVariable (value = "id") Long id) {
		userService.deleteUser(id);
		return "User deleted sucessfully";
		
	}
	
}
