package api.resource.connection;

import api.dto.token.TokenDto;
import api.resource.dto.connection.ConnectionDto;
import application.service.authentication.AuthenticationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ConnectionJsonResourceTest {

	private static final String A_USERNAME = "karim";
	private static final String A_PASSWORD = "RealMAdrid89**";
	private ConnectionJsonResource connectionJsonResource;
	@Mock
	private AuthenticationService authenticationService;
	private ConnectionDto connectionDto;

	private void setUpDto(){
		connectionDto = new ConnectionDto();

		connectionDto.setUsername(A_USERNAME);
		connectionDto.setPassword(A_PASSWORD);
	}

	@Before
	public void setUp(){
		connectionJsonResource = new ConnectionJsonResource(authenticationService);
	}

	@Test
	public void whenLoggingIn_thenDelegateToAuthenticationService()throws Exception{

 authenticationService.authenticate(connectionDto);

		verify(authenticationService).authenticate(connectionDto);
	}

	@Test
	public void whenLoggingOut_thenDelegateAuthenticationService()throws Exception {

		authenticationService.logout(connectionDto);

		verify(authenticationService).logout(connectionDto);

	}

}
