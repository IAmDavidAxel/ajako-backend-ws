package application.exception;

import application.service.exception.ServiceException;
import domain.CouronneAfroDomainException;

public class EntityCreationServiceException extends ServiceException {
	public EntityCreationServiceException(CouronneAfroDomainException cause) {
		super(cause);
	}
}
