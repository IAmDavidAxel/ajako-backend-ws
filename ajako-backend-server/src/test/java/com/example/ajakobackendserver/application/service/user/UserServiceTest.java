package com.example.ajakobackendserver.application.service.user;

import com.example.ajakobackendserver.api.dto.user.UserDto;
import com.example.ajakobackendserver.application.service.user.UserService;
import com.example.ajakobackendserver.domain.user.User;
import com.example.ajakobackendserver.domain.user.UserFactory;
import com.example.ajakobackendserver.domain.user.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	private UserDto userDto;
	private User user;

	private UserService userService;

	@Mock
	private UserRepository userRepository;
	@Mock
	private UserFactory userFactory;

	@Before
	public void setUp()throws Exception{
		userService = new UserService(userFactory,userRepository);

		willReturn(user).given(userFactory).create(userDto);
	}

	@Test
	public void whenCreatingANewUser_thenDelegateCreationToFactory()throws Exception{
		userService.create(userDto);

		verify(userFactory).create(userDto);
	}

	@Test
	public void whenCreatingANewUser_thenDelegateSavingToRepo()throws Exception{
		userService.create(userDto);

		verify(userRepository).save(user);
	}


}
