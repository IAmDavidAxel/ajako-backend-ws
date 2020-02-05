package domain.user.password;

public interface PasswordFactory {
	public Password create(String password) throws IllegalPasswordFormatException;
}
