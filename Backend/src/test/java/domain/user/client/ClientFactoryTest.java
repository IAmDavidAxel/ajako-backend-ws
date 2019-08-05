package domain.user.client;


import api.dto.user.client.ClientDto;
import domain.credential.CredentialFactory;
import domain.password.IllegalPasswordFormatException;
import domain.password.Password;
import domain.password.PasswordFactory;
import domain.token.Token;
import domain.token.TokenFactory;
import domain.user.AccessLevel;
import domain.user.InvalidUserNameException;
import domain.user.UserId;
import domain.user.UserIdFactory;
import domain.userprofile.UserProfileFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ClientFactoryTest {

	private static final String A_LAST_NAME = "David";
	private static final String A_FIRST_NAME = "Catherine";
	private static final String AN_EMAIL = "dodo@hotmail.fr";
	private static final String A_PLAIN_PASSWORD = "JOjo45Giorno**";
	private static final String A_PHONE_NUMBER = "587-888-7412";
	private static final String A_USERNAME = "GiornoGolden";

	private ClientFactory clientFactory;
	private ClientDto clientDto;
	private UserId userId;


	@Mock
	private PasswordFactory passwordFactory;
	@Mock
	private TokenFactory tokenFactory;
	@Mock
	private UserIdFactory userIdFactory;
	@Mock
	private UserProfileFactory userProfileFactory;
	@Mock
	private CredentialFactory credentialFactory;
	private Password password;
	private Token token;

	private void setUpDto(){
		clientDto = new ClientDto();

		clientDto.setLastName(A_LAST_NAME);
		clientDto.setFirstName(A_FIRST_NAME);
		clientDto.setEmail(AN_EMAIL);
		clientDto.setPasswordValue(A_PLAIN_PASSWORD);
		clientDto.setPhoneNumber(A_PHONE_NUMBER);
		clientDto.setUsername(A_USERNAME);
	}


	@Before
	public void setUp(){
		setUpDto();

		clientFactory = new ClientFactory(passwordFactory,tokenFactory,userIdFactory,userProfileFactory,credentialFactory);
	}

	@Test
	public void whenCreatingANewClient_thenDelegatePasswordCreationToFactory()throws Exception{

		clientFactory.create(clientDto);

		verify(passwordFactory).create(A_PLAIN_PASSWORD);
	}

	@Test(expected = InvalidUserNameException.class)
	public void whenCreatingANewClient_thenInvalidUserNameExceptionIsThrown()throws Exception{

		clientDto.setUsername(AN_EMAIL);

		clientFactory.create(clientDto);
	}

	@Test(expected = IllegalPasswordFormatException.class)
	public void whenCreatingANewClientWithInvalidPasswordFormat_thenExceptionIsThrown() throws Exception{

		willThrow(IllegalPasswordFormatException.class).given(passwordFactory).create(A_PLAIN_PASSWORD);

		clientFactory.create(clientDto);
	}

	@Test
	public void whenCreatingANewClient_thenDelegateTokenCreationToFactory()throws Exception{

		clientFactory.create(clientDto);

		verify(tokenFactory).create();
	}

	@Test
	public void whenCreatingANewClient_thenDelegateProfileCreationToUserProfileFactory()throws Exception{

		willReturn(userId).given(userIdFactory).create();

		clientFactory.create(clientDto);

		verify(userProfileFactory).create(userId,A_USERNAME,A_FIRST_NAME,A_LAST_NAME,A_PHONE_NUMBER);
	}

	@Test
	public void whenCreatingANewClient_thenDelegateCredentialCreationToFactory()throws Exception{

		willReturn(password).given(passwordFactory).create(A_PLAIN_PASSWORD);

		clientFactory.create(clientDto);

		verify(credentialFactory).create(password,token, AccessLevel.CLIENT);
	}


}
