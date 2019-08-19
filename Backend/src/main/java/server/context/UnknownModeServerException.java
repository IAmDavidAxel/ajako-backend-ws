package server.context;

@SuppressWarnings("serial")
public class UnknownModeServerException extends RuntimeException {

	public UnknownModeServerException(){
		super(" Unknown running mode");
	}

}
