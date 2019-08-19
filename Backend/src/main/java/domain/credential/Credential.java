package domain.credential;

import domain.datetime.DateTime;
import domain.password.Password;
import domain.token.IllegalTokenValidationException;
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

	public Token generateToken() {

		if (token==null){
			this.token = new Token(new DateTime());
		}

		this.token.generate();

		return token;
	}

	public void verify(String password) throws MismatchedPasswordException{

		this.password.verify(password);

	}

	public boolean isValid(String decodedToken) throws IllegalTokenValidationException {
		this.token.verifyValue(decodedToken);

		return false;
	}

	public void invalidateToken() {
		token.invalidate();
	}

	public boolean haveAccessTo(AccessLevel accessLevel) {
		return this.accessLevel == accessLevel;
	}
}
