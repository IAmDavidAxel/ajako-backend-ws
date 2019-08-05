package domain.credential;

import domain.password.Password;
import domain.token.Token;
import domain.user.AccessLevel;

public class CredentialFactory {
	public Credential create(Password password, Token token, AccessLevel accessLevel) {

		return  new Credential(password,token,accessLevel);
	}
}
