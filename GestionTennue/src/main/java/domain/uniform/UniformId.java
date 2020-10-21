package domain.uniform;

import java.util.UUID;

public class UniformId {

	private String idValue;

	public UniformId(){
		generateId();
	}

	private void generateId() {
		this.idValue = UUID.randomUUID().toString();
	}

	public String getIdValue() {
		return idValue;
	}

	public void setId(String id) {
		this.idValue = id;
	}
}
