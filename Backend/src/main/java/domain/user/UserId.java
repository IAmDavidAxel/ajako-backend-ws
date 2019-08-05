package domain.user;

import javax.jws.soap.SOAPBinding;
import java.util.UUID;

public class UserId {


	private String id;

	public UserId(String id) {
		this.id = id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserId(){
		generateId();
	}


	public String getIdValue() {
		return this.id;
	}

	private void generateId(){
		id = UUID.randomUUID().toString();
	}



}
