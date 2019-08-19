package server.context;

import api.resource.user.client.ClientResource;
import domain.password.PasswordPolicy;
import server.context.resourcesContext.ClientResourceContext;

public class DevelopmentContext extends Context {

	@Override
	public void registerServices() {
		/**
		 * Registering security services
		 */

	}


	@Override
	public void initializeResource() {

		ClientResource  clientResource = ClientResourceContext.create();

		this.resourcesContext.add(clientResource);
	}
}
