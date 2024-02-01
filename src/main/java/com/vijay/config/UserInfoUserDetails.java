package com.vijay.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vijay.model.UserEntity;

public class UserInfoUserDetails implements UserDetails {

	private String username;
	private String password;
	private List<GrantedAuthority> authorities;
	
	public UserInfoUserDetails(UserEntity userEntity) {
		username = userEntity.getUsername();
		password = userEntity.getPassword();
		authorities = Arrays.stream(userEntity.getRole().split(","))
						.map(SimpleGrantedAuthority::new)
						.collect(Collectors.toList());
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

}
