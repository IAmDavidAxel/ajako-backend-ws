package com.example.ajakobackendserver.api.resource.user.client;

import com.example.ajakobackendserver.api.dto.user.UserDto;
import com.example.ajakobackendserver.application.user.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserJsonResource {
	private UserService userService;

	public UserJsonResource(UserService userService) {

		this.userService = userService;
	}

	public void create(UserDto userDto) throws Exception{

		userService.create(userDto);
	}
}
