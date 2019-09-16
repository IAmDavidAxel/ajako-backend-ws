package api.resource.user.barber;

public class BarberDto {
	private String username;
	private String passwordValue;
	private String firstName;
	private String lastName;
	private String phoneNumber;

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPasswordValue(String passwordValue) {
		this.passwordValue = passwordValue;
	}

	public String getPasswordValue() {
		return passwordValue;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
}
