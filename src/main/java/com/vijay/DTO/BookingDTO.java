package com.vijay.DTO;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BookingDTO {
	
	private Integer roomNo;
	private String manager;
	private Long userId;
	private Date checkInTime;
	private Date checkOutTime;
	
}
