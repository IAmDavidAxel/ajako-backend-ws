package api.resource.connection;

import api.dto.token.TokenDto;
import api.resource.dto.connection.ConnectionDto;
import application.service.authentication.AuthenticationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ConnectionJsonResourceTest {

	private ConnectionJsonResource connectionJsonResource;
	private AuthenticationService authenticationService;
	private ConnectionDto connectionDto;

	@Before
	public void setUp(){
		connectionJsonResource = new ConnectionJsonResource(authenticationService);
	}

	@Test
	public void whenLoggingIn_thenDelegateToAuthenticationService()throws Exception{

		TokenDto tokenDto = authenticationService.authenticate(connectionDto);
	}

}
