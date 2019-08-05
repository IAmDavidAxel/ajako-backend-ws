package domain.user;

import domain.CouronneAfroDomainException;

public class InvalidUserNameException extends CouronneAfroDomainException {

	public InvalidUserNameException(String username) {
		super("le nom d'utilisateur : "+ username + " et le email ne doivent pas etre les memes");
	}
}
