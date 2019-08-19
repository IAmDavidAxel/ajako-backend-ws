package domain.password;

public class JBCryptPasswordFactory implements PasswordFactory {

	private PasswordPolicy passwordPolicy;

	public JBCryptPasswordFactory(PasswordPolicy passwordPolicy) {
		this.passwordPolicy = passwordPolicy;
	}

	@Override
	public Password create(String password) throws IllegalPasswordFormatException {
		return null;
	}
}
