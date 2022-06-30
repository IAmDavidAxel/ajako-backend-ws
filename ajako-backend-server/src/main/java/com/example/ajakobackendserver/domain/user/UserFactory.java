package com.example.ajakobackendserver.domain.user;

import com.example.ajakobackendserver.api.dto.user.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserFactory {
	public User create(UserDto userDto) {

		String name = userDto.getName();
		String lastName = userDto.getLastName();
		String dateOfBirth = userDto.getDateOfBirth();
		String address = userDto.getAddress();
		String country = userDto.getCountry();
		String city = userDto.getCity();
		String province = userDto.getProvince();
		String zipCode = userDto.getZipCode();
		String email = userDto.getEmail();
		String password = userDto.getPASSWORD();
		String username = userDto.getUsername();
		String phoneNumber = userDto.getPhoneNumber();


		return new User(name,lastName,dateOfBirth,phoneNumber,password,email,username,
				address,zipCode,city,province,country);
	}

	public UserDto create(User user){
		UserDto userDto = new UserDto();

		userDto.setUsername(user.getUsername());
		userDto.setProvince(user.getProvince());
		userDto.setCountry(user.getCountry());
		userDto.setZipCode(user.getZipCode());
		userDto.setAddress(user.getAddress());
		userDto.setEmail(user.getEmail());
		userDto.setName(user.getName());
		userDto.setCity(user.getCity());
		userDto.setLastName(user.getLastName());
		userDto.setPhoneNumber(user.getPhoneNumber());

		return userDto;
	}

	public List<UserDto> createToList(List<User> users){

		return users.stream().map(this::create).collect(Collectors.toList());
	}
}
