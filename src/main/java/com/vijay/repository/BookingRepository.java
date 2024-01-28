package com.vijay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.model.BookingEntity;

import jakarta.validation.Valid;

public interface BookingRepository extends JpaRepository<BookingEntity, Long>{

	List<BookingEntity> findByUserId(@Valid Long userId);

}
