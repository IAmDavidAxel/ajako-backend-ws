package utility.serviceLocator;

import server.context.UnknownModeServerException;

public class UnknownResolvedServiceException extends RuntimeException {

	public UnknownResolvedServiceException(){
		super("Cannot resolve the service may not be registered");
	}
}
