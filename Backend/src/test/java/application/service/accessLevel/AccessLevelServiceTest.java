package application.service.accessLevel;

import domain.credential.Credential;
import domain.credential.CredentialRepository;
import domain.user.AccessLevel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccessLevelServiceTest {

	private static final String USERNAME = "Mamamam";
	private static final AccessLevel CLIENT_ACCESS_LEVEL = AccessLevel.CLIENT;
	private AccessLevelService accessLevelService;

	@Mock
	private CredentialRepository credentialRepository;
	@Mock
	private Credential credential;

	@Before
	public void setUp(){
		accessLevelService = new AccessLevelService(credentialRepository);
	}

	@Test
	public void whenVerifyingAccessLevel_thenDelegateFindingCredentialToRepo()throws Exception{

		accessLevelService.verifyAccessLevel(USERNAME,CLIENT_ACCESS_LEVEL);

		verify(credentialRepository).findByUsername(USERNAME);
	}

	@Test
	public void whenVerifyingAccessLevel_thenDelegateGrantingAccessToCredential()throws Exception{

		accessLevelService.verifyAccessLevel(USERNAME,CLIENT_ACCESS_LEVEL);

		verify(credential).haveAccessTo(CLIENT_ACCESS_LEVEL);

	}

}
