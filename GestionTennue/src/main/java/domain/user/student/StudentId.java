package domain.user.student;

import java.util.UUID;

public class StudentId {


	private String idValue;

	public StudentId() {
		generateId();
	}

	private void generateId() {
		this.idValue = UUID.randomUUID().toString();
	}

	public String getIdValue() {
		return idValue;
	}

	public void setIdValue(String idValue) {
		this.idValue = idValue;
	}
}
