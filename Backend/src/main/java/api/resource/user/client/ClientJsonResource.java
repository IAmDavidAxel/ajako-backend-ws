package api.resource.user.client;

import api.dto.user.client.ClientDto;
import application.service.exception.ServiceException;
import application.service.user.client.ClientService;

public class ClientJsonResource implements ClientResource {

	private ClientService clientService;

	public ClientJsonResource(ClientService clientService) {

		this.clientService = clientService;
	}

	@Override
	public void create(ClientDto clientDto) throws ServiceException {

		clientService.create(clientDto);

	}
}
