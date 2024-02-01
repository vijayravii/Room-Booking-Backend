package com.vijay.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.vijay.config.UserInfoUserDetails;
import com.vijay.model.UserEntity;
import com.vijay.repository.UserRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> optional = userRepository.findByUsername(username);
		
		return optional.map(UserInfoUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found Exception"+username));
	}

}
