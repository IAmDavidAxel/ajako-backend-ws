package domain.user.client;

import api.dto.user.client.ClientDto;
import domain.credential.Credential;
import domain.credential.CredentialFactory;
import domain.password.IllegalPasswordFormatException;
import domain.password.Password;
import domain.password.PasswordFactory;
import domain.token.Token;
import domain.token.TokenFactory;
import domain.user.*;
import domain.userprofile.UserProfile;
import domain.userprofile.UserProfileFactory;

public class ClientFactory  implements UserFactory<Client,ClientDto> {

	private  PasswordFactory passwordFactory;
	private  TokenFactory tokenFactory;
	private  UserIdFactory userIdFactory;
	private  UserProfileFactory userProfileFactory;
	private  CredentialFactory credentialFactory;

	public ClientFactory(PasswordFactory passwordFactory, TokenFactory tokenFactory, UserIdFactory userIdFactory, UserProfileFactory userProfileFactory, CredentialFactory credentialFactory) {

		this.passwordFactory = passwordFactory;
		this.tokenFactory = tokenFactory;
		this.userIdFactory = userIdFactory;
		this.userProfileFactory = userProfileFactory;
		this.credentialFactory = credentialFactory;
	}

	public Client create(ClientDto clientDto)  throws IllegalPasswordFormatException, InvalidUserNameException {

		String firstName = clientDto.getFirstName();
		String lastName = clientDto.getLastName();
		String email = clientDto.getEmail();
		String username = clientDto.getUsername();
		String passwordValue = clientDto.getPasswordValue();
		String phoneNumber = clientDto.getPhoneNumber();

		if (username.equals(email)){
			throw  new InvalidUserNameException(username);
		}

		Password password = passwordFactory.create(passwordValue);
		Token token = tokenFactory.create();
		UserId userId = userIdFactory.create();
		UserProfile userProfile = userProfileFactory.create(userId,username,firstName,lastName,phoneNumber);
		Credential credential = credentialFactory.create(password,token, AccessLevel.CLIENT);

		return new Client(userProfile,credential,email);
	}
}
