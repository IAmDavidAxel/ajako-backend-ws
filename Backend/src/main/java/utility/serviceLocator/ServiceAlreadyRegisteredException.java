package utility.serviceLocator;

public class ServiceAlreadyRegisteredException extends RuntimeException {

	public ServiceAlreadyRegisteredException(){
		super("the provided service is already registered");
	}
}
