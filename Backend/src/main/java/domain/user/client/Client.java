package domain.user.client;

import domain.credential.Credential;
import domain.userprofile.UserProfile;

public class Client {
	private  UserProfile userProfile;
	private  Credential credential;
	private  String email;

	public Client(UserProfile userProfile, Credential credential, String email) {

		this.userProfile = userProfile;
		this.credential = credential;
		this.email = email;
	}
}
