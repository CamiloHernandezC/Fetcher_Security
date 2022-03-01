package com.fetcher.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
	
	@GetMapping("/users")
	public String getUsers() {
		return "Hola mundo";
	}

}
