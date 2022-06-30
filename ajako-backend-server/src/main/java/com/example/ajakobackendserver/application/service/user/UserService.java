package com.example.ajakobackendserver.application.service.user;

import com.example.ajakobackendserver.api.dto.user.UserDto;
import com.example.ajakobackendserver.domain.user.User;
import com.example.ajakobackendserver.domain.user.UserFactory;
import com.example.ajakobackendserver.domain.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private UserFactory userFactory;
	private UserRepository userRepository;

	public UserService(UserFactory userFactory, UserRepository userRepository ){
		this.userFactory = userFactory;
		this.userRepository = userRepository;
	}

	public void create(UserDto userDto) {
		User user = createUserFromFactory(userDto);
		save(user);

	}

	private void save(User user) {
		userRepository.save(user);
	}

	private User createUserFromFactory(UserDto userDto) {
		return userFactory.create(userDto);
	}
}
