package com.fetcher.security.services.interfaces;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new User("foo","$2a$12$sOzDqVsjJ.0uGDIsyEkgPOFaNR68cxhqRM2gOG1E/MhbXsp5EiYUq",new ArrayList<>());
	}

}
