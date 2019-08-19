package application.service.authentication;

import api.resource.dto.connection.ConnectionDto;
import application.service.security.SecurityAssembler;
import domain.credential.Credential;
import domain.credential.CredentialRepository;
import domain.token.Token;
import domain.token.TokenEncoder;
import domain.token.TokenExpirationPolicy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationServiceTest {

	private static final TokenExpirationPolicy AN_EXPERATION_TERM = TokenExpirationPolicy.MID_TERM;
	private static final String A_PASSWORD = "CristianoRoro23**";
	private static final String A_USERNAME = "MamaBoy";
	private static final String A_TOKEN = "";
	private static final String ACCESS_TOKEN = "Z3Y5UjE2Z0FobDBNVEVNMU9qTER3QVhUM20xdkhyT2w3dDlhN21jQnA5ZTQ1N2hQUmZ5bG85anZJbHJ6LlNvbWVVc2VybmFtZQ==";
	private static final long EXPIRES_IN = AN_EXPERATION_TERM.expiresIn();

	private AuthenticationService authenticationService;
	@Mock
	private Token token;

	@Mock
	private CredentialRepository credentialRepository;
	@Mock
	private TokenEncoder tokenEncoder;

	@Mock
	private SecurityAssembler securityAssembler;
	private ConnectionDto connectionDto;
	@Mock
	private Credential credential;



	private void setUpDto(){
		connectionDto = new ConnectionDto();

		connectionDto.setPassword(A_PASSWORD);
		connectionDto.setUsername(A_USERNAME);
	}

	@Before
	public void setUp() throws Exception{
		setUpDto();
		authenticationService = new AuthenticationService(credentialRepository,tokenEncoder,securityAssembler);


		willReturn(credential).given(credentialRepository).findByUsername(A_USERNAME);
		willReturn(token).given(credential).generateToken();
		willReturn(ACCESS_TOKEN).given(tokenEncoder).encode(A_USERNAME, A_TOKEN);
		willReturn(A_TOKEN).given(token).getTokenValue();
		willReturn(TokenExpirationPolicy.MID_TERM).given(token).getPolicy();

		willReturn(A_TOKEN).given(tokenEncoder).getToken();
		willReturn(A_USERNAME).given(tokenEncoder).getSalt();
	}

	@Test
	public void whenAuthenticating_thenDelegateCredentialFindingToTheRepo()throws Exception{

		authenticationService.authenticate(connectionDto);

		verify(credentialRepository).findByUsername(A_USERNAME);
	}

	@Test
	public void whenAuthenticating_thenDelegateTokenGeneration()throws Exception{

		authenticationService.authenticate(connectionDto);

		verify(credential).generateToken();
	}

	@Test
	public void whenAuthenticating_thenDelegateCredentialSavingToTheRepo()throws Exception{

		authenticationService.authenticate(connectionDto);

		verify(credentialRepository).saveCredential(credential,A_USERNAME);

	}
	@Test
	public void whenAuthenticating_thenTokenEncoderEncodesNewToken()throws Exception{

		authenticationService.authenticate(connectionDto);

		verify(tokenEncoder).encode(A_USERNAME, token.getTokenValue());
	}

	@Test
	public void whenValidatingToken_thenDelegateDecodingToTokenEncoder()throws Exception {

		authenticationService.validateToken(A_TOKEN);

		verify(tokenEncoder).decode(A_TOKEN);
	}

}
