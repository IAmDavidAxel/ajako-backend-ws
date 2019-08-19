package utility.datamanager;

public class MessageDataManager {

	// API response type
	public static final String SUCCESS_RESPONSE = "succeeded";
	public static final String FAIL_RESPONSE = "failed";

	// API general response message
	public static final String BAD_REQUEST_RESPONSE = "One or more provided information does not respect requirements.";
	public static final String INTERNAL_SERVER_ERROR = "An internal error occurred on the server side.";
	public static final String UNAUTHORIZED_TOKEN_ACCESS = "Provided access token is either invalid or has expired.";
	public static final String FORBIDDEN_ROLE_ACCESS = "Insufficient privileges to access the resource.";

	public static final String PASSWORD_POLICY_VIOLATION =
			"The password provided is violating our password policy. At least one uppercase, one lower case, one special character and one number. The password length should be minimum of 8 character.";
	public static final String INCORRECT_PASSWORD = "The password provided is incorrect, did You forgot your password?";


	// API resource response message
	public static final String CLIENT_CREATED = "Creation succeeded, check you emails for confirmation.";
	public static final String CLIENT_UPDATED = "Client profile updated with success.";
	public static final String CLIENT_PASSWORD_UPDATED = "Client password updated with success.";
	public static final String CLIENT_NOT_FOUND = "The client does not exist.";
	public static final String CLIENT_ALREADY_EXIST = "The chosen username is unavailable.";

	// Connection resource messages
	public static final String LOGIN_SUCCEEDED = "Login succeeded, you may use you account.";
	public static final String LOGIN_DENIED = "Login denied, check the information provided.";
	public static final String LOGOUT_SUCCEEDED = "Logout succeeded, you need to login to access you account.";

	public static final String BARBER_CREATED = "Barber successfully created";
}
