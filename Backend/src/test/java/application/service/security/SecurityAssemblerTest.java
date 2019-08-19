package application.service.security;

import api.dto.token.TokenDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SecurityAssemblerTest {

	private static final long EXPIRES_IN = 3694L;
	private static final String TOKEN = "token975451sdqsdqs";
	private SecurityAssembler securityAssembler;

	@Before
	public void setUp(){
		securityAssembler = new SecurityAssembler();
	}

	@Test
	public void whenAssembling_thenAllDtoValuesAreTheSameAsExpected(){

		TokenDto tokenDto = securityAssembler.toTokenDto(TOKEN,EXPIRES_IN);

		assertEquals(TOKEN, tokenDto.getToken());
		assertEquals(EXPIRES_IN, tokenDto.getExpireIn());
	}

}
