package domain.userprofile;

import domain.user.UserId;

public class UserProfile {
	private  UserId userId;
	private  String username;
	private  String firstName;
	private  String lastName;
	private  String phoneNumber;

	public UserProfile(UserId userId, String aUsername, String aFirstName, String aLastName, String aPhoneNumber) {

		this.userId = userId;
		this.username = aUsername;
		this.firstName = aFirstName;
		this.lastName = aLastName;
		this.phoneNumber = aPhoneNumber;
	}
}
