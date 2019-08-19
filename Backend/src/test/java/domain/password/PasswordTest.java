package domain.password;

import domain.credential.MismatchedPasswordException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordTest {

	private static final String A_PASSWORD = "S0mePa55word";
	private static final String ANOTHER_PASSWORD = "Ano7h3rPa55word";
	private static final String NULL_DIGEST = null;
	private Password password;

	@Before
	public void setUpInitialPasswordWithNullDigest() throws Exception {
		password = new Password(A_PASSWORD);
	}

	@Test
	public void givenPassword_whenInitialized_thenShouldNotBeEmpty() {
		String passwordDigest = password.getDigest();

		assertNotEquals(NULL_DIGEST, passwordDigest);

	}

	@Test
	public void whenHashingPassword_thenHashShouldBeDifferentFromInputPassword() {
		password.generateFromString(A_PASSWORD);
		String passwordDigest = password.getDigest();

		assertNotEquals(A_PASSWORD, passwordDigest);
	}

	@Test
	public void whenHashingTheSamePasswordTwice_thenShouldNotProduceTheSameDigest() {
		password.generateFromString(A_PASSWORD);
		String firstDigest = password.getDigest();
		password.generateFromString(A_PASSWORD);
		String secondDigest = password.getDigest();

		assertNotEquals(firstDigest, secondDigest);
	}

	@Test
	public void whenVerifyingWithRightPassword_thenShouldReturnTrue() throws MismatchedPasswordException {
		password.verify(A_PASSWORD);
	}

	@Test(expected = MismatchedPasswordException.class)
	public void whenVerifyingWitchWrongPassword_thenShouldRaiseMismatchedPasswordException()
			throws MismatchedPasswordException {
		password.verify(ANOTHER_PASSWORD);
	}

	@Test
	public void givenHashingPasswordTwice_whenVerifiying_ShouldReturnTrue() throws MismatchedPasswordException {
		password.generateFromString(A_PASSWORD);
		password.generateFromString(A_PASSWORD);

		password.verify(A_PASSWORD);
	}

}
