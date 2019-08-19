package utility.token;

import domain.token.IllegalTokenValidationException;

import javax.ws.rs.container.ContainerRequestContext;
import java.util.List;

public class AccessTokenHeaderExtractor {

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_VALUE_FLAG = "Bearer\\s";
	private static final String EMPTY_STRING = "";

	public String extractToken(ContainerRequestContext containerRequestContext) throws IllegalTokenValidationException {
		List<String> authHeader = containerRequestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
		if (authHeader != null && authHeader.size() > 0) {
			String token = authHeader.get(0);
			token = token.replaceFirst(AUTHORIZATION_HEADER_VALUE_FLAG, EMPTY_STRING);
			return token;
		} else {
			throw new IllegalTokenValidationException();
		}
	}

}
