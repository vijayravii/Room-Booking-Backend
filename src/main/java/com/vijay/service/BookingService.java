package com.vijay.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.DTO.BookingDTO;
import com.vijay.exception.UserNotFoundException;
import com.vijay.model.BookingEntity;
import com.vijay.model.RoomEntity;
import com.vijay.repository.BookingRepository;
import com.vijay.repository.RoomRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Service
public class BookingService {

	private static final Logger logger = LogManager.getLogger(BookingService.class);

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	RoomRepository roomRepository;
	
	public BookingEntity createBooking(BookingDTO bookingDTO) {
		BookingEntity bookingEntity = new BookingEntity();
		bookingEntity.setRoomNo(bookingDTO.getRoomNo());
		bookingEntity.setManager(bookingDTO.getManager());
		bookingEntity.setUserId(bookingDTO.getUserId());
		bookingEntity.setCheckInTime(bookingDTO.getCheckInTime());
		bookingEntity.setCheckOutTime(bookingDTO.getCheckOutTime());
		
		RoomEntity roomEntity;
		
		Optional<RoomEntity> optional = roomRepository.findByRoomNo(bookingDTO.getRoomNo());
		if(optional.isPresent()) {
			roomEntity = optional.get();
			roomEntity.setStatus("Occupied");
			roomRepository.save(roomEntity);
		} else {
			logger.info("Cannot update the Status");
		}
		return bookingRepository.save(bookingEntity);
	}


	public List<BookingEntity> getBooking() {
		return bookingRepository.findAll();
	}
	
	//Exception Handling is not done here check UserService

	public BookingEntity editBooking(Long id, BookingDTO bookingDTO) {
		
		BookingEntity bookingEntity = bookingRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User is not found for id : " + id));

		Optional<BookingEntity> optional = bookingRepository.findById(id); 
		if(!optional.isPresent()) {
			logger.info("Booking not found");
		} else {
			bookingEntity.setRoomNo(bookingDTO.getRoomNo());
			bookingEntity.setManager(bookingDTO.getManager());
			bookingEntity.setUserId(bookingDTO.getUserId());
			bookingEntity.setCheckInTime(bookingDTO.getCheckInTime());
			bookingEntity.setCheckOutTime(bookingDTO.getCheckOutTime());
		}
		return bookingRepository.save(bookingEntity);
	}
	
	public void deleteBooking(@Valid Long id) {
		bookingRepository.deleteById(id);
	}

	public List<BookingEntity> getBookingByUserId(Long userId) {
		return bookingRepository.findByUserId(userId);
	}

}
