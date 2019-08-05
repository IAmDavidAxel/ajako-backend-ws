package application.service.user.client;

import api.dto.user.client.ClientDto;
import application.exception.EntityCreationServiceException;
import application.service.exception.ServiceException;
import domain.password.IllegalPasswordFormatException;
import domain.user.InvalidUserNameException;
import domain.user.client.Client;
import domain.user.client.ClientFactory;
import domain.user.client.ClientRepository;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientService {

	private ClientFactory clientFactory;
	private ClientRepository clientRepository;

	public ClientService(ClientFactory clientFactory, ClientRepository clientRepository) {

		this.clientFactory = clientFactory;
		this.clientRepository = clientRepository;
	}

	public void create(ClientDto clientDto)  throws ServiceException {

		Client client = createClient(clientDto);

	}

	private Client createClient(ClientDto clientDto) throws ServiceException {

		try {
			return  clientFactory.create(clientDto);
		}catch (IllegalPasswordFormatException | InvalidUserNameException e){
			Logger.getGlobal().log(Level.SEVERE,e.getMessage());
			throw new EntityCreationServiceException(e);
		}
	}
}
