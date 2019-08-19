package middleware;

import application.service.authentication.AuthenticationService;
import application.service.exception.ServiceException;
import middleware.authentication.AuthenticationMiddleware;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import utility.token.AccessTokenHeaderExtractor;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationMiddlewareTest {

	private static final String TOKEN ="token";


	private AuthenticationMiddleware authenticationMiddleware;

	@Mock
	private ContainerRequestContext containerRequestContext;
	@Mock
	private AuthenticationService authenticationService;

	@Mock
	private AccessTokenHeaderExtractor tokenHeaderExtractor;

	@Before
	public void setUp() throws Exception{

		authenticationMiddleware = new AuthenticationMiddleware(authenticationService,tokenHeaderExtractor);

		willReturn(TOKEN).given(tokenHeaderExtractor).extractToken(containerRequestContext);
		willThrow(new ServiceException()).given(authenticationService).validateToken(TOKEN);
	}

	@Test
	public void givenANonValidToken_whenFiltering_thenAbortTheRequestWithResponse()throws Exception{

		authenticationMiddleware.filter(containerRequestContext);

		verify(containerRequestContext).abortWith(any(Response.class));

	}


}
