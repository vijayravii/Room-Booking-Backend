package com.vijay.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.DTO.RoomDTO;
import com.vijay.exception.UserNotFoundException;
import com.vijay.model.RoomEntity;
import com.vijay.repository.RoomRepository;

import jakarta.validation.Valid;

@Service
public class RoomService {

	private static final Logger logger = LogManager.getLogger(RoomService.class);

	@Autowired
	RoomRepository roomRepository;

	public RoomEntity createRoom(RoomDTO roomDTO) {
		RoomEntity roomEntity = new RoomEntity();
		roomEntity.setRoomNo(roomDTO.getRoomNo());
		roomEntity.setLocation(roomDTO.getLocation());
		roomEntity.setAddress(roomDTO.getAddress());
		roomEntity.setStatus("Available");
		roomEntity.setPrice(roomDTO.getPrice());
		return roomRepository.save(roomEntity);
	}

	public List<RoomEntity> getRoom() {
		return roomRepository.findAll();
	}

	//Exception Handling is not done here check UserService
	
	public RoomEntity updateRoom(Long id, RoomDTO roomDTO) {

		RoomEntity roomEntity = roomRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User is not found for id : " + id));
		
		Optional<RoomEntity> optional = roomRepository.findById(id);
		
		if(!optional.isPresent()) {
			logger.info("Room not found");
		} else {
			logger.info("Triggering");
			roomEntity =  optional.get();
			roomEntity.setLocation(roomDTO.getLocation());
			roomEntity.setAddress(roomDTO.getAddress());
			roomEntity.setPrice(roomDTO.getPrice());
		}
		return roomRepository.save(roomEntity);

	}
	
	public void deleteRoom(@Valid Long id) {
		roomRepository.deleteById(id);
		
	}

}
