package application.service.accessLevel;

import domain.credential.Credential;
import domain.credential.CredentialRepository;
import domain.user.AccessLevel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccessLevelServiceTest {

	private static final String USERNAME = "Mamamama";
	private static final AccessLevel CLIENT_ACCESS_LEVEL = AccessLevel.CLIENT;
	private AccessLevelService accessLevelService;

	@Mock
	private CredentialRepository credentialRepository;
	@Mock
	private Credential credential;

	@Before
	public void setUp() throws Exception{
		accessLevelService = new AccessLevelService(credentialRepository);

		willReturn(credential).given(credentialRepository).findByUsername(USERNAME);
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
