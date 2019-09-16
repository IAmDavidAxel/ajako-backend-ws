package application.service.user.client;

import api.dto.user.client.ClientDto;
import api.resource.appointment.AppointmentDto;
import application.exception.EntityCreationServiceException;
import application.service.exception.ServiceException;
import domain.password.IllegalPasswordFormatException;
import domain.user.InvalidUserNameException;
import domain.user.barber.Barber;
import domain.user.barber.BarberRepository;
import domain.user.client.Client;
import domain.user.client.ClientFactory;
import domain.user.client.ClientRepository;
import infrastructure.repository.user.client.ClientNotFoundException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientService {

	private ClientFactory clientFactory;
	private ClientRepository clientRepository;
	private BarberRepository barberRepository;

	public ClientService(ClientFactory clientFactory, ClientRepository clientRepository, BarberRepository barberRepository) {

		this.clientFactory = clientFactory;
		this.clientRepository = clientRepository;
		this.barberRepository = barberRepository;
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

	public void makeHairAppointment(AppointmentDto appointmentDto) throws ServiceException {

		String clientUsername = appointmentDto.getClientUsername();
		String barberUsername = appointmentDto.getBarberUsername();

		Client client = findingClient(clientUsername);
		Barber barber = findingBarber(barberUsername);


	}

	private Barber findingBarber(String barberUsername) {
		return null;
	}

	private Client findingClient(String clientUsername) throws ServiceException{

		try{
			return clientRepository.findClientByUsername(clientUsername);
		}catch (ClientNotFoundException exception){
			Logger.getGlobal().log(Level.SEVERE, exception.getMessage());
			throw  new ClientNotFoundServiceException();
		}
	}
}
