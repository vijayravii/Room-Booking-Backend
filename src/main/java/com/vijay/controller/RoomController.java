package com.vijay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.DTO.RoomDTO;
import com.vijay.model.RoomEntity;
import com.vijay.service.RoomService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class RoomController {
		
	@Autowired
	RoomService roomService;
	
	@PostMapping("room")
	public RoomEntity createRoom(@RequestBody RoomDTO roomDTO){
		return roomService.createRoom(roomDTO);
	}

	@GetMapping("room")
	public List<RoomEntity> getRoom() {
		return roomService.getRoom();
	}
	
	@PutMapping("room/{id}")
	public ResponseEntity<RoomEntity> updateRoom(@PathVariable Long id, @RequestBody RoomDTO roomDTO) {
		RoomEntity updateRoom = roomService.updateRoom(id, roomDTO); 
		return ResponseEntity.status(HttpStatus.OK).body(updateRoom);
	}

	@DeleteMapping("room/{id}")
	public String deleteRoom(@Valid @PathVariable (value = "id") Long id) {
		roomService.deleteRoom(id);
		return "Room deleted sucessfully";
		
	}
	
}
