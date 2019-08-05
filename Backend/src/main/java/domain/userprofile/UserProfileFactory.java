package domain.userprofile;

import domain.user.UserId;
import domain.userprofile.UserProfile;

public class UserProfileFactory {
	public UserProfile create(UserId userId, String aUsername, String aFirstName, String aLastName, String aPhoneNumber) {


		return new UserProfile(userId,aUsername,aFirstName,aLastName,aPhoneNumber);
	}
}
