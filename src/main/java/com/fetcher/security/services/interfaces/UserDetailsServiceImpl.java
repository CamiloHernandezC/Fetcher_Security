package com.fetcher.security.services.interfaces;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fetcher.security.entities.User;
import com.fetcher.security.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<com.fetcher.security.entities.User> opt = userRepository.findByUsername(username);
		 if(opt.isEmpty()) {
			 log.error("User {} not found in database", username		);
			 throw new UsernameNotFoundException("User not found in database");
		 }
		 log.info("User {} found in database", username);
		 User user = opt.get();
		 Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		 user.getRoles().forEach(role -> 
		 	authorities.add(new SimpleGrantedAuthority(role.getName())));
		 return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
	}

}
