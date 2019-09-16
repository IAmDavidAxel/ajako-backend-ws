package server.context.resourcesContext;

import api.dto.user.client.ClientDto;
import api.resource.user.client.ClientJsonResource;
import api.resource.user.client.ClientResource;
import application.service.user.client.ClientService;
import domain.credential.CredentialFactory;
import domain.password.JBCryptPasswordFactory;
import domain.password.PasswordFactory;
import domain.password.PasswordPolicy;
import domain.token.TokenFactory;
import domain.user.UserFactory;
import domain.user.UserIdFactory;
import domain.user.client.Client;
import domain.user.client.ClientFactory;
import domain.user.client.ClientRepository;
import domain.userprofile.UserProfileFactory;
import utility.serviceLocator.ServiceLocator;

public class ClientResourceContext {
	public static ClientResource create() {

		PasswordPolicy passwordPolicy = ServiceLocator.INSTANCE.resolve(PasswordPolicy.class);
		ClientRepository  clientRepository = ServiceLocator.INSTANCE.resolve(ClientRepository.class);

		PasswordFactory passwordFactory = new JBCryptPasswordFactory(passwordPolicy);
		TokenFactory tokenFactory = new TokenFactory();

		UserIdFactory userIdFactory = new UserIdFactory();

		UserProfileFactory userProfileFactory = new UserProfileFactory();
		CredentialFactory credentialFactory = new CredentialFactory();
		UserFactory<Client, ClientDto> clientFactory = new ClientFactory(passwordFactory,tokenFactory,userIdFactory,userProfileFactory,credentialFactory);

		ClientService clientService = new ClientService((ClientFactory) clientFactory,clientRepository, barberRepository);

		return new ClientJsonResource(clientService);
	}
}
