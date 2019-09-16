package api.resource.appointment;

public class AppointmentDto {

	public String clientUsername;
	public String barberUsername;

	public String getClientUsername() {
		return clientUsername;
	}

	public void setClientUsername(String clientUsername) {
		this.clientUsername = clientUsername;
	}

	public String getBarberUsername() {
		return barberUsername;
	}

	public void setBarberUsername(String barberUsername) {
		this.barberUsername = barberUsername;
	}
}
