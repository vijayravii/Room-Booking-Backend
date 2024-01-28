package com.vijay.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "room")
public class RoomEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "room_no")
	private Integer roomNo;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "price")
	private Integer price;

}
