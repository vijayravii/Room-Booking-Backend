package com.vijay.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.TABLE)
	private Long id;
	
    @NotEmpty(message = "Full Name may not be empty")
    @Column(name = "full_name")
	private String fullName;
	
    @NotEmpty(message = "Mobile Number may not be empty")
    @Pattern(regexp="(^$|[0-9]{10})")
	@Column(name = "mobile_no")
	private String mobileNo;
	
	@Column(name="role")
	private String role;
	
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",flags = Pattern.Flag.CASE_INSENSITIVE)
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
    @NotEmpty(message = "UserName may not be empty")
	@Column(name = "username")
	private String username;
	
    @NotEmpty(message = "Password may not be empty")
	@Column(name = "password")
	private String password;
	
}
