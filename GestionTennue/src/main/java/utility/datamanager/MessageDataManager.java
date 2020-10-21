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
	public static final String ASSIGNATION_CONFLICT = "A required assignation is missing.";

	public static final String PASSWORD_POLICY_VIOLATION =
			"The password provided is violating our password policy. At least one uppercase, one lower case, one special character and one number. The password length should be minimum of 8 character.";
	public static final String INCORRECT_PASSWORD = "The password provided is incorrect, did You forgot your password?";

	// API resource response message
	public static final String CLIENT_CREATED = "Creation succeeded, check you emails for confirmation.";
	public static final String CLIENT_UPDATED = "Client profile updated with success.";
	public static final String CLIENT_PASSWORD_UPDATED = "Client password updated with success.";
	public static final String CLIENT_NOT_FOUND = "The client does not exist.";
	public static final String CLIENT_ALREADY_EXIST = "The chosen username is unavailable.";
	public static final String CLIENT_COURSE_STATE = "State of your taxi order";
	public static final String CLIENT_INVALID_USERNAME = "Invalid provided username, the username should be different from you mail address.";
	public static final String CLIENT_ORDER_MISSING = "There is no order.";

	public static final String DRIVER_CREATED = "Creation succeeded, you may now login as a driver.";
	public static final String DRIVER_ASSIGNED = "Driver isAssigned to the provided vehicle.";
	public static final String DRIVER_DISASSOCIATED = "The driver has been disassociated from his current vehicle.";
	public static final String DRIVER_AT_DEPARTURE_POINT = "The driver has arrived at the departure point.";
	public static final String DRIVER_ALREADY_EXIST = "Can't add this driver, he may be existing in the system.";
	public static final String DRIVER_NOT_FOUND = "The driver does not exist.";

	public static final String VEHICLE_CREATED = "Creation succeeded, a new vehicle has been added to the database.";
	public static final String VEHICLE_ALREADY_EXIST = "Can't add the provided vehicle, it may be existing in the system.";
	public static final String VEHICLE_POSITION_UPDATE = "The position of the vehicle has been updated with success";
	public static final String VEHICLE_COORDINATES_ASSIGNATION_CONFLICT = "Coordinates could not be set to the vehicle.";

	public static final String COURSE_ASSOCIATED = "Driver isAssigned to the provided course.";
	public static final String COURSE_STARTED = "The client entered the taxi.";
	public static final String COURSE_FINISHED = "The course is finished.";
	public static final String COURSE_CREATED = "Creation succeeded, a driver will respond to you order soon.";
	public static final String COURSE_CANCELLED = "Your course has been canceled.";
	public static final String COURSE_AVAILABLE = "List of available courses.";
	public static final String COURSE_CANCEL_ERROR = "Your order could not be cancelled because no course in progress has been found.";
	public static final String COURSE_NOT_FOUND = "The course does not exist.";
	public static final String COURSE_ALREADY_IN_PROGRESS = "You have already a course in progress, you can't order a new one.";
	public static final String COURSE_NOT_ASSIGNED = "No course is assigned.";
	public static final String COURSE_FINISH_CONFLICT = "You can't finish the actual course.";

	// Connection resource messages
	public static final String LOGIN_SUCCEEDED = "Login succeeded, you may use you account.";
	public static final String LOGIN_DENIED = "Login denied, check the information provided.";
	public static final String LOGOUT_SUCCEEDED = "Logout succeeded, you need to login to access you account.";

}
