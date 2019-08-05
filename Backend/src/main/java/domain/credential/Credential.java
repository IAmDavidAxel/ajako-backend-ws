package domain.credential;

import domain.password.Password;
import domain.token.Token;
import domain.user.AccessLevel;

public class Credential {

	private  Password password;
	private  Token token;
	private  AccessLevel accessLevel;

	public Credential(Password password, Token token, AccessLevel accessLevel) {

		this.password = password;
		this.token = token;
		this.accessLevel = accessLevel;
	}
}
