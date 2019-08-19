package domain.password;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicPasswordPolicyTest {


	private static final String A_VALID_LENGTH_PASSWORD = "1234567890";
	private static final String NOT_VALID_LENGTH = "abaca";
	private static final String VALID_PATTERN_PASSWORD = "Wint3rIsC0ming!4";
	private static final String NOT_VALID_PATTERN = "kaka";
	private static final String VALID_PASSWORD = "SansaSta3rk**";
	private static final String INVALID_PASSWORD = "popo456*";

	private BasicPasswordPolicy basicPasswordPolicy;

	@Before
	public void setUp(){
		basicPasswordPolicy = new BasicPasswordPolicy();
	}

	@Test
	public void whenAPasswordHasAValidLength_thenReturnTrue(){

		boolean isValidLength = basicPasswordPolicy.isValidLength(A_VALID_LENGTH_PASSWORD);

		assertTrue(isValidLength);
	}

	@Test
	public void whenPasswordDoesNotHaveValidLength_thenReturnFalse(){

		boolean isNotValidLength = basicPasswordPolicy.isValidLength(NOT_VALID_LENGTH);

		assertFalse(isNotValidLength);
	}

	@Test
	public void whenPasswordHasTheRightPattern_thenReturnTrue(){

		boolean isValidPattern = basicPasswordPolicy.isValidPattern(VALID_PATTERN_PASSWORD);

		assertTrue(isValidPattern);
	}

	@Test
	public void whenPasswordDoesNotHaveARightPattern_thenReturnFalse(){

		boolean isNotValidPattern = basicPasswordPolicy.isValidPattern(NOT_VALID_PATTERN);

		assertFalse(isNotValidPattern);
	}

	@Test
	public void whenPasswordHasBothValidPatternAndLength_thenReturnTrue(){

		boolean isValid = basicPasswordPolicy.isValid(VALID_PASSWORD);

		assertTrue(isValid);
	}

	@Test
	public void whenPasswordIsNotValidOverall_thenReturnFalse(){
		boolean isInvalid = basicPasswordPolicy.isValid(INVALID_PASSWORD);

		assertFalse(isInvalid);
	}


}
