package domain.user.barber;

import api.resource.user.barber.BarberDto;
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

public class BarberFactory  implements UserFactory<Barber, BarberDto> {


	private  PasswordFactory passwordFactory;
	private  TokenFactory tokenFactory;
	private  CredentialFactory credentialFactory;
	private  UserIdFactory userIdFactory;
	private  UserProfileFactory userProfileFactory;

	public BarberFactory(PasswordFactory passwordFactory, TokenFactory tokenFactory, CredentialFactory credentialFactory, UserIdFactory userIdFactory, UserProfileFactory userProfileFactory) {

		this.passwordFactory = passwordFactory;
		this.tokenFactory = tokenFactory;
		this.credentialFactory = credentialFactory;
		this.userIdFactory = userIdFactory;
		this.userProfileFactory = userProfileFactory;
	}

	@Override
	public Barber create(BarberDto creationDto) throws IllegalPasswordFormatException, InvalidUserNameException {

		String username = creationDto.getUsername();
		String passwordValue = creationDto.getPasswordValue();
		String firstName = creationDto.getFirstName();
		String lastName = creationDto.getLastName();
		String cellPhoneNumber = creationDto.getPhoneNumber();

		Password password = passwordFactory.create(passwordValue);
		Token token = tokenFactory.create();
		Credential credential = credentialFactory.create(password,token, AccessLevel.BARBER);
		UserId userId = userIdFactory.create();
		UserProfile userProfile = userProfileFactory.create(userId,username,firstName,lastName,cellPhoneNumber);


		return new Barber(userProfile,credential,cellPhoneNumber);
	}
}
