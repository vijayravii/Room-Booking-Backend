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

import com.vijay.DTO.BookingDTO;
import com.vijay.model.BookingEntity;
import com.vijay.service.BookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("admin")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("booking")
	public BookingEntity createBooking(@RequestBody BookingDTO bookingDTO){
		return bookingService.createBooking(bookingDTO);
	}

	@GetMapping("booking")
	public List<BookingEntity> getBooking() {
		return bookingService.getBooking();
	}
	
	@PutMapping("booking/{id}")
	public ResponseEntity<BookingEntity> editBooking(@PathVariable Long id, @RequestBody BookingDTO bookingDTO) throws IOException {
		BookingEntity editBooking = bookingService.editBooking(id, bookingDTO); 
		return ResponseEntity.status(HttpStatus.OK).body(editBooking);
	}
	
	@DeleteMapping("booking/{id}")
	public String deleteBooking(@Valid @PathVariable (value = "id") Long id) {
		bookingService.deleteBooking(id);
		return "Booking deleted sucessfully";
		
	}
	
	@GetMapping("userbookings/{userId}")
	public List<BookingEntity> getBookingByUserId(@PathVariable (value = "userId") Long userId) {
		return bookingService.getBookingByUserId(userId);
	}

	
	
}
