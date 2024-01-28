package com.vijay.model;

import java.sql.Date;

import org.apache.catalina.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "booking")
public class BookingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "room_no")
	private Integer roomNo;
	
	@Column(name = "manager")
	private String manager;
	
	@Column(name = "userId")
	private Long userId;
	
	@Column(name = "check_in_time")
	private Date checkInTime;
	
	@Column(name = "check_out_time")
	private Date checkOutTime;

}
