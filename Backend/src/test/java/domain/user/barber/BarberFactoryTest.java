package domain.user.barber;

import api.resource.user.barber.BarberDto;
import domain.credential.CredentialFactory;
import domain.password.Password;
import domain.password.PasswordFactory;
import domain.token.Token;
import domain.token.TokenFactory;
import domain.user.AccessLevel;
import domain.user.UserId;
import domain.user.UserIdFactory;
import domain.userprofile.UserProfileFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BarberFactoryTest {

	private static final String USERNAME = "kaka";
	private static final String PASSWORD_VALUE = "popo";
	private static final String FIRST_NAME = "kady";
	private static final String LAST_NAME = "jolie";
	private static final AccessLevel BARBER_ACCESS_LEVEL = AccessLevel.BARBER;
	private static final String PHONE_NUMBER = "587-888-8798";

	private BarberFactory barberFactory;
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
	@Mock
	private Password password;

	private BarberDto barberDto;
	 @Mock
	private Token token;
	 @Mock
	private UserId userId;

	private void setUpDto(){
		barberDto = new BarberDto();

		barberDto.setUsername(USERNAME);
		barberDto.setPasswordValue(PASSWORD_VALUE);
		barberDto.setFirstName(FIRST_NAME);
		barberDto.setLastName(LAST_NAME);
		barberDto.setPhoneNumber(PHONE_NUMBER);
	}

	@Before
	public void setUp() throws Exception{
		setUpDto();
		barberFactory = new BarberFactory(passwordFactory,tokenFactory,credentialFactory,userIdFactory,userProfileFactory);

		willReturn(password).given(passwordFactory).create(PASSWORD_VALUE);
		willReturn(token).given(tokenFactory).create();
		willReturn(userId).given(userIdFactory).create();

	}

	@Test
	public void whenCreatingADomainObject_thenDelegateToPasswordFactory()throws Exception{
		barberFactory.create(barberDto);

		verify(passwordFactory).create(PASSWORD_VALUE);
	}

	@Test
	public void whenCreatingADomainObject_thenDelegateTokenCreationToFactory()throws Exception{

		barberFactory.create(barberDto);

		verify(tokenFactory).create();
	}

	@Test
	public void whenCreatingADomainObject_thenDelegateCredentialCreationToFactory()throws Exception{

		barberFactory.create(barberDto);

		verify(credentialFactory).create(password,token,BARBER_ACCESS_LEVEL);
	}

	@Test
	public void whenCreatingADomainObject_thenDelegateProfileCreationToFactory()throws Exception{
		barberFactory.create(barberDto);

		verify(userProfileFactory).create(userId,USERNAME,FIRST_NAME,LAST_NAME,PHONE_NUMBER);
	}



}
