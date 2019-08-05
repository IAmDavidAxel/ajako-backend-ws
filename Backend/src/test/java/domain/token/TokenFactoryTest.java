package domain.token;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import utility.datamanager.ApplicationConfiguration;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TokenFactoryTest {

	private static final String MIDTERM_EXPIRATION_POLICY = "midterm";
	private TokenFactory tokenFactory;

	@Before
	public void setUp(){
		tokenFactory = new TokenFactory();
	}

	@Test
	public void whenCreatingAToken_thenCreateAToken(){

		ApplicationConfiguration.tokenExpirationPolicyFromProperties = MIDTERM_EXPIRATION_POLICY;

		Object token = tokenFactory.create();

		assertNotNull(token);


	}


}
