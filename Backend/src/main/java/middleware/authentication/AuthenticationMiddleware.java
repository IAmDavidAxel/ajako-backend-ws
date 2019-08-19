package middleware.authentication;

import api.dto.ResponseDto;
import api.response.ResponseDtoBuilder;
import application.service.authentication.AuthenticationService;
import application.service.exception.ServiceException;
import domain.token.IllegalTokenValidationException;
import utility.datamanager.MessageDataManager;
import utility.token.AccessTokenHeaderExtractor;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthenticationMiddleware implements ContainerRequestFilter {
	private  AuthenticationService authenticationService;
	private  AccessTokenHeaderExtractor tokenHeaderExtractor;

	public AuthenticationMiddleware(AuthenticationService authenticationService, AccessTokenHeaderExtractor tokenHeaderExtractor) {

		this.authenticationService = authenticationService;
		this.tokenHeaderExtractor = tokenHeaderExtractor;
	}

	@Override
	public void filter(ContainerRequestContext requestContext)  {

		try{
			String accessToken = tokenHeaderExtractor.extractToken(requestContext);
			authenticationService.validateToken(accessToken);
		}catch (ServiceException| IllegalTokenValidationException e){
			Logger.getGlobal().log(Level.WARNING, e.getMessage());
		}

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.FAIL_RESPONSE)
				.withMessage(MessageDataManager.UNAUTHORIZED_TOKEN_ACCESS)
				.getResponseDto();

		Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED).entity(responseDto).build();

		requestContext.abortWith(unauthorizedStatus);

	}
}
