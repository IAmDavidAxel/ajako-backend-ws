package application.service.accessLevel;

import application.service.exception.ServiceException;

public class ForbiddenResourceAccessServiceException extends ServiceException {

	public ForbiddenResourceAccessServiceException(String access_forbidden) {
		super(access_forbidden);
	}
}
