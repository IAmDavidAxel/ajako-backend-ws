package domain.token;

import domain.CouronneAfroDomainException;

@SuppressWarnings("serial")
public class IllegalTokenValidationException extends CouronneAfroDomainException {

	public IllegalTokenValidationException() {
		super("the token provided is incorrect");
	}
}
