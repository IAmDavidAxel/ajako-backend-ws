package middleware.role;

import application.service.accessLevel.AccessLevelService;
import application.service.accessLevel.ForbiddenResourceAccessServiceException;
import application.service.exception.ServiceException;
import domain.token.IllegalTokenValidationException;
import domain.token.Token;
import domain.token.TokenEncoder;
import domain.user.AccessLevel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import utility.token.AccessTokenHeaderExtractor;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;

import java.awt.geom.RectangularShape;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HasRoleMiddlewareTest {

	private static final String USERNAME = "username";
	private static final AccessLevel ACCESS_LEVEL = AccessLevel.CLIENT;

	private HasRoleMiddleware middleware;

	@Mock
	private AccessTokenHeaderExtractor tokenExtractor;
	@Mock
	private AccessLevelService accessLevelService;
	@Mock
	private ContainerRequestContext requestContext;
	@Mock
	private TokenEncoder tokenEncoder;

	@Before
	public void setUp() throws Exception{
		middleware = new HasRoleMiddleware(ACCESS_LEVEL,accessLevelService,tokenExtractor,tokenEncoder);

		willReturn(USERNAME).given(tokenEncoder).getSalt();
		String token = "toktok";
		willReturn(token).given(tokenExtractor).extractToken(requestContext);
	}

	@Test
	public void whenFilteringWithAnError_thenAbortWithAResponse()throws Exception{
		willThrow( new ServiceException()).given(accessLevelService).verifyAccessLevel(USERNAME,ACCESS_LEVEL);

		middleware.filter(requestContext);

		verify(requestContext).abortWith(any(Response.class));
	}

	@Test
	public void givenAForbiddenAccessException_whenFiltering_thenAbortTheRequestWithAResponse() throws Exception {
		willThrow(new ForbiddenResourceAccessServiceException("SomeMessage")).given(accessLevelService).verifyAccessLevel(USERNAME, ACCESS_LEVEL);

		middleware.filter(requestContext);

		verify(requestContext).abortWith(any(Response.class));
	}

	@Test
	public void givenAnInvalidProvideToken_whenFiltering_thenAbortTheRequestWithAResponse() throws Exception {

		willThrow(new IllegalTokenValidationException()).given(tokenExtractor).extractToken(requestContext);

		middleware.filter(requestContext);

		verify(requestContext).abortWith(any(Response.class));
	}

	@Test
	public void givenAFailedVerificationOfTheAccessToken_whenFiltering_thenAbortTheRequestWithAResponse() throws Exception {
		willReturn(false).given(accessLevelService).verifyAccessLevel(USERNAME, ACCESS_LEVEL);

		middleware.filter(requestContext);

		verify(requestContext).abortWith(any(Response.class));
	}
}
