package com.example.ajakobackendserver.domain.user;

import com.example.ajakobackendserver.api.dto.user.UserDto;

public interface UserRepository {
	void save(User user);
}
