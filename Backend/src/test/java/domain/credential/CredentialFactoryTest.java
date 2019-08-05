package domain.credential;

import domain.password.Password;
import domain.token.Token;
import domain.user.AccessLevel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CredentialFactoryTest {

	private CredentialFactory credentialFactory;

	@Mock
	private Token token;
	@Mock
	private Password password;

	@Before
	public void setUp(){
		credentialFactory = new CredentialFactory();
	}

	@Test
	public void whenCreatingANewCredentialObject_thenItsNotNull(){

		Credential credentialFromFactory = credentialFactory.create(password,token, AccessLevel.CLIENT);

		assertNotNull(credentialFromFactory);
	}




}
