package infrastructure.persistence.dao.sqlite.builder;

public class DaoEntityNotFoundException extends Exception {

	public DaoEntityNotFoundException() {
		super("The entity does not exists in the database.");
	}
}
