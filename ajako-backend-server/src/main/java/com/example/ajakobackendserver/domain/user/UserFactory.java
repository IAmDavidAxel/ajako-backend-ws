package com.example.ajakobackendserver.domain.user;

import com.example.ajakobackendserver.api.dto.user.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {
	public User create(UserDto userDto) {

		return new User();
	}
}
