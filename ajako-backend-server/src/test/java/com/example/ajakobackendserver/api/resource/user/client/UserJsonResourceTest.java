package com.example.ajakobackendserver.api.resource.user.client;


import com.example.ajakobackendserver.api.dto.user.UserDto;
import com.example.ajakobackendserver.application.user.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserJsonResourceTest {

	private UserJsonResource userJsonResource;

	@Mock
	private UserService userService;
	private UserDto userDto;

	@Before
	public void setUp()throws Exception{

		userJsonResource = new UserJsonResource(userService);
	}

	@Test
	public void whenCreatingANewUser_thenDelegateToService()throws Exception{

		userJsonResource.create(userDto);

		verify(userService).create(userDto);
	}
}
