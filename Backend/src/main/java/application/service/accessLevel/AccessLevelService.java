package application.service.accessLevel;

import application.service.authentication.PersistenceInternalServiceException;
import application.service.exception.ServiceException;
import domain.credential.Credential;
import domain.credential.CredentialRepository;
import domain.credential.ObjectNotFoundException;
import domain.user.AccessLevel;
import infrastructure.repository.credential.PersistenceInternalException;

public class AccessLevelService {

	private CredentialRepository credentialRepository;

	public AccessLevelService(CredentialRepository credentialRepository) {

		this.credentialRepository = credentialRepository;
	}

	public boolean verifyAccessLevel(String username, AccessLevel resourceAccessLevel) throws ServiceException {

		try{
			Credential credential = credentialRepository.findByUsername(username);
			return credential.haveAccessTo(resourceAccessLevel);
		}catch (ObjectNotFoundException exception){
			throw  new ForbiddenResourceAccessServiceException("Access forbidden");
		}catch (PersistenceInternalException exception){
			throw  new PersistenceInternalServiceException();
		}
	}
}
