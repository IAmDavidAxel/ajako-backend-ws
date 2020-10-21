package infrastructure.persistence.dao;

@SuppressWarnings("serial")
public class DaoInternalException extends Exception {

	public DaoInternalException() {
		super("An internal persistence error occured.");
	}
}
