package domain.credential;

import domain.CouronneAfroDomainException;

@SuppressWarnings("serial")
public class MismatchedPasswordException extends CouronneAfroDomainException {
	public MismatchedPasswordException() {
		super("le mot de passe que vous avez entré ne correspond a celui dans le système");
	}
}
