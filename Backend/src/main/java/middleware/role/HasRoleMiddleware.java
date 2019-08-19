package middleware.role;

import api.dto.ResponseDto;
import api.response.ResponseDtoBuilder;
import application.service.accessLevel.AccessLevelService;
import application.service.accessLevel.ForbiddenResourceAccessServiceException;
import application.service.exception.ServiceException;
import domain.token.IllegalTokenValidationException;
import domain.token.ParsingTokenEncoderException;
import domain.token.TokenEncoder;
import domain.user.AccessLevel;
import utility.datamanager.MessageDataManager;
import utility.token.AccessTokenHeaderExtractor;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HasRoleMiddleware {
	private  AccessLevel resourceAccessLevel;
	private  AccessLevelService accessLevelService;
	private  AccessTokenHeaderExtractor tokenExtractor;
	private  TokenEncoder tokenEncoder;
	private ResponseDto responseDto;
	private Response roleFilterResponse;

	public HasRoleMiddleware(AccessLevel accessLevel, AccessLevelService accessLevelService, AccessTokenHeaderExtractor tokenExtractor, TokenEncoder tokenEncoder) {

		this.resourceAccessLevel = accessLevel;
		this.accessLevelService = accessLevelService;
		this.tokenExtractor = tokenExtractor;
		this.tokenEncoder = tokenEncoder;
	}


	public void filter(ContainerRequestContext requestContext) {

		try{
			String username = extractUsernameFromAccessToken(requestContext);

			if (accessLevelService.verifyAccessLevel(username,resourceAccessLevel)){
				return;
			} else {
				generateForbiddenResponse();
			}
		}catch (ForbiddenResourceAccessServiceException exception){
			Logger.getGlobal().log(Level.INFO, exception.getMessage());
			generateForbiddenResponse();
		}catch (ServiceException exception){
			Logger.getGlobal().log(Level.INFO, exception.getMessage());
			generateInternalErrorResponse();
		}catch (IllegalTokenValidationException exception){
			Logger.getGlobal().log(Level.INFO, exception.getMessage());
			generateUnauthorizedResponse();
		}

		requestContext.abortWith(roleFilterResponse);
	}

	private String extractUsernameFromAccessToken(ContainerRequestContext requestContext) throws IllegalTokenValidationException {

		String accessToken = tokenExtractor.extractToken(requestContext);

		tokenEncoder.decode(accessToken);

		return tokenEncoder.getSalt();
	}

	private void generateInternalErrorResponse() {
		responseDto = ResponseDtoBuilder.builder().withStatus(MessageDataManager.FAIL_RESPONSE).withMessage(MessageDataManager.INTERNAL_SERVER_ERROR).getResponseDto();

		roleFilterResponse = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(responseDto).build();
	}

	private void generateForbiddenResponse() {
		responseDto = ResponseDtoBuilder.builder().withStatus(MessageDataManager.FAIL_RESPONSE).withMessage(MessageDataManager.FORBIDDEN_ROLE_ACCESS).getResponseDto();

		roleFilterResponse = Response.status(Response.Status.FORBIDDEN).entity(responseDto).build();
	}

	private void generateUnauthorizedResponse() {
		responseDto = ResponseDtoBuilder.builder().withStatus(MessageDataManager.FAIL_RESPONSE).withMessage(MessageDataManager.UNAUTHORIZED_TOKEN_ACCESS).getResponseDto();

		roleFilterResponse = Response.status(Response.Status.UNAUTHORIZED).entity(responseDto).build();
	}
}
