package com.example.ajakobackendserver.api.resource.user.client;

import com.example.ajakobackendserver.api.dto.user.UserDto;
import com.example.ajakobackendserver.application.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserJsonResource {
	private UserService userService;

	public UserJsonResource(UserService userService) {

		this.userService = userService;
	}

	@PostMapping("/sign-up")
	public ResponseEntity<Object> create(@RequestBody UserDto userDto) throws Exception{

		userService.create(userDto);

		return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
	}
}
