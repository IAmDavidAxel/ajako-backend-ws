package domain.user.barber;

import domain.credential.Credential;
import domain.userprofile.UserProfile;

public class Barber {

	private  UserProfile userProfile;
	private  Credential credential;
	private  String cellPhoneNumber;

	public Barber(UserProfile userProfile, Credential credential, String cellPhoneNumber) {

		this.userProfile = userProfile;
		this.credential = credential;
		this.cellPhoneNumber = cellPhoneNumber;
	}
}
