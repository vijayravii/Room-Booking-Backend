package com.vijay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.model.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, Long>{

	Optional<RoomEntity> findByRoomNo(Integer roomNo);

}
