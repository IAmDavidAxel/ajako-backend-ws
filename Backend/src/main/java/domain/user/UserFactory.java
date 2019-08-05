package domain.user;

import domain.password.IllegalPasswordFormatException;

public interface UserFactory<User, UserDto> {

	User create(UserDto creationDto) throws IllegalPasswordFormatException, InvalidUserNameException;
}
