package domain.credential;

import infrastructure.repository.credential.PersistenceInternalException;

public interface CredentialRepository {

	Credential findByUsername(String username) throws ObjectNotFoundException, PersistenceInternalException;

	void saveCredential(Credential credential, String username) throws PersistenceInternalException;
}
