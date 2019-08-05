package domain.password;

import domain.CouronneAfroDomainException;

public class IllegalPasswordFormatException extends CouronneAfroDomainException {


	public IllegalPasswordFormatException() {
		super("le mot de passe que vous avez entré ne respecte pas les politiques de sécurité");
	}
}
