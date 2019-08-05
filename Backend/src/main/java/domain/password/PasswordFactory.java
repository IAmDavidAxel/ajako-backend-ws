package domain.password;

public interface PasswordFactory {

	Password create(String password) throws IllegalPasswordFormatException;
}
