package server;

import org.eclipse.jetty.server.Server;
import utility.datamanager.ApplicationConfiguration;

import java.util.logging.Logger;

public class BackendServer {

	private static final Logger SERVER_LOGGER = Logger.getLogger(BackendServer.class.getName());

	private Server server;

	public static void main (String[] args) throws Exception{

		SERVER_LOGGER.info("Loading application configuration");
		PropertyConfiguration property = new PropertyConfiguration(ApplicationConfiguration.PROPERTIES_FILE_NAME);
		property.initialize();
		property.apply();


	}


}
