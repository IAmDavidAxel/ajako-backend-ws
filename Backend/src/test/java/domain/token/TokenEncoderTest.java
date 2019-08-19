package domain.token;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TokenEncoderTest {

	private static final String ORIGINAL_USERNAME = "SomeUsername";
	private static final String ORIGINAL_TOKEN = "gv9R16gAhl0MTEM1OjLDwAXT3m1vHrOl7t9a7mcBp9e457hPRfylo9jvIlrz";
	private static final String ENCODED_TOKEN = "Z3Y5UjE2Z0FobDBNVEVNMU9qTER3QVhUM20xdkhyT2w3dDlhN21jQnA5ZTQ1N2hQUmZ5bG85anZJbHJ6LlNvbWVVc2VybmFtZQ==";
	private static final String BAD_ENCODED_TOKEN="asdfasdf32a1sdf321asdf354asdf324a3sd2f4";
	private static final String NON_BASE64_TOKEN = "@#$%123321321a321321321";

	private TokenEncoder tokenEncoder;

	@Before
	public void setUp(){
		tokenEncoder = new TokenEncoder();
	}

	@Test
	public void initializedTheUsernameShouldBeNull(){
		assertNull(tokenEncoder.getSalt());
	}

	@Test
	public void initializedTheTokenShouldBeNull(){
		assertNull(tokenEncoder.getToken());
	}

	@Test
	public void whenEncodingTheTokenWithAUsername_thenShouldBeEqualToTheRightEncodedString(){
		String actualEncodedToken = tokenEncoder.encode(ORIGINAL_USERNAME, ORIGINAL_TOKEN);

		assertEquals(ENCODED_TOKEN,actualEncodedToken);
	}

	@Test
	public void whenDecoding_thenTheSaltShouldNotBeNull() throws Exception {
		tokenEncoder.decode(ENCODED_TOKEN);

		assertNotNull(tokenEncoder.getSalt());
	}

	@Test
	public void whenDecoding_thenTheSaltShouldBeTheSameAsTheOriginalUsername() throws Exception {
		tokenEncoder.decode(ENCODED_TOKEN);

		assertEquals(ORIGINAL_USERNAME,tokenEncoder.getSalt());
	}

	@Test
	public void whenDecoding_thenTheTokenShouldNotBeNull() throws Exception {
		tokenEncoder.decode(ENCODED_TOKEN);

		assertNotNull(tokenEncoder.getToken());
	}

	@Test
	public void whenDecoding_thenTheTokenShouldBeTheSameAsTheOriginalToken() throws Exception {
		tokenEncoder.decode(ENCODED_TOKEN);

		assertEquals(ORIGINAL_TOKEN,tokenEncoder.getToken());
	}

	@Test (expected = ParsingTokenEncoderException.class)
	public void givenNoConformEncodedToken_whenDecoding_thenRaiseParsingTokenEncoderException() throws Exception{
		tokenEncoder.decode(BAD_ENCODED_TOKEN);
	}

	@Test (expected = ParsingTokenEncoderException.class)
	public void givenNoBase64EncodedToken_whenDecoding_thenRaiseParsingTokenEncoderException() throws Exception{
		tokenEncoder.decode(NON_BASE64_TOKEN);
	}

}
