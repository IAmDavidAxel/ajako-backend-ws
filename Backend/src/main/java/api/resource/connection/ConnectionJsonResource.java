package api.resource.connection;

import api.resource.dto.connection.ConnectionDto;
import application.service.authentication.AuthenticationService;
import application.service.exception.ServiceException;

import javax.ws.rs.core.Response;

public class ConnectionJsonResource implements ConnectionResource {

	private AuthenticationService authenticationService;

	public ConnectionJsonResource(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@Override
	public Response login(ConnectionDto connectionDto) throws ServiceException {


		return null;
	}

	@Override
	public Response logout(ConnectionDto connectionDto) throws ServiceException {
		return null;
	}
}
