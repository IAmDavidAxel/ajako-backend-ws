package utility.token;

import domain.token.IllegalTokenValidationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.MultivaluedMap;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class AccessTokenHeaderExtractorTest {

	private AccessTokenHeaderExtractor accessTokenHeaderExtractor;
	private List<String> authHeader;

	@Mock
	private ContainerRequestContext containerRequestContext;

	@Before
	public void setUp(){
		accessTokenHeaderExtractor= new AccessTokenHeaderExtractor();

		MultivaluedMap<String, String> headers = mock(MultivaluedMap.class);
		willReturn(headers).given(containerRequestContext).getHeaders();
		authHeader = new ArrayList<>();
		willReturn(authHeader).given(headers).get(anyString());
	}

	@Test(expected = IllegalTokenValidationException.class)
	public void givenAuthHeaderWithEmptyValue_whenExtractingToken_thenRaiseAnException() throws Exception {
		accessTokenHeaderExtractor.extractToken(containerRequestContext);
	}

	@Test
	public void givenAuthHeaderWithValue_whenExtractingToken_ReturnTheTokenAfterTheBearerMark() throws Exception {
		authHeader.add("Bearer SomeToken");

		String extractedToken = accessTokenHeaderExtractor.extractToken(containerRequestContext);

		assertEquals("SomeToken", extractedToken);
	}

}
