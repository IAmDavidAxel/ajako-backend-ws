package application.service.authentication;

import api.dto.token.TokenDto;
import api.resource.dto.connection.ConnectionDto;
import application.service.exception.ServiceException;
import application.service.security.SecurityAssembler;
import domain.credential.Credential;
import domain.credential.CredentialRepository;
import domain.credential.MismatchedPasswordException;
import domain.credential.ObjectNotFoundException;
import domain.token.IllegalTokenValidationException;
import domain.token.Token;
import domain.token.TokenEncoder;
import infrastructure.repository.credential.PersistenceInternalException;

public class AuthenticationService {

	private CredentialRepository credentialRepository;
	private TokenEncoder tokenEncoder;
	private SecurityAssembler securityAssembler;

	public AuthenticationService(CredentialRepository credentialRepository, TokenEncoder tokenEncoder, SecurityAssembler securityAssembler) {

		this.credentialRepository = credentialRepository;
		this.tokenEncoder = tokenEncoder;
		this.securityAssembler = securityAssembler;
	}

	public TokenDto authenticate(ConnectionDto connectionDto)  throws ServiceException {

		Credential credential;

		String username = connectionDto.getUsername();
		String password = connectionDto.getPassword();

		try{
			 credential = credentialRepository.findByUsername(username);
			 credential.verify(password);
		}catch (ObjectNotFoundException |MismatchedPasswordException exception){
			throw  new NotAuthenticatedServiceException();
		}catch (PersistenceInternalException exception){
			throw  new PersistenceInternalServiceException();
		}


		Token updatedToken = credential.generateToken();

		try{
			credentialRepository.saveCredential(credential,username);
		}catch (PersistenceInternalException exception){

			throw  new PersistenceInternalServiceException();
		}

		String accessToken = tokenEncoder.encode(username, updatedToken.getTokenValue());


		return securityAssembler.toTokenDto(accessToken,updatedToken.getPolicy().expiresIn());
	}


	public boolean validateToken(String accessToken) throws ServiceException {

		try{
			tokenEncoder.decode(accessToken);

			String username = tokenEncoder.getSalt();
			String decodedToken = tokenEncoder.getToken();

			Credential credential = credentialRepository.findByUsername(username);

			return credential.isValid(decodedToken);
		}catch (IllegalTokenValidationException | ObjectNotFoundException exception){
			 throw  new InvalidTokenServiceException();
		} catch (PersistenceInternalException exception){
			throw  new PersistenceInternalServiceException();
		}
	}

	public void logout(ConnectionDto connectionDto) throws ServiceException{
		String username = connectionDto.getUsername();

		Credential credential = null;
		try {
			credential = credentialRepository.findByUsername(username);
			credential.invalidateToken();
			credentialRepository.saveCredential(credential, username);
		} catch (PersistenceInternalException | ObjectNotFoundException exception) {
			throw new PersistenceInternalServiceException();
		}


	}
}
