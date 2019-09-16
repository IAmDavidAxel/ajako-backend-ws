package application.service.user.client;



import api.dto.user.client.ClientDto;
import api.resource.appointment.AppointmentDto;
import domain.user.barber.BarberRepository;
import domain.user.client.ClientFactory;
import domain.user.client.ClientRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

	private static final String CLIENT_USERNAME = "kok";
	private static final String BARBER_USERNAME = "bibi";
	private ClientService clientService;

	@Mock
	private ClientFactory clientFactory;
	@Mock
	private ClientRepository clientRepository;
	private ClientDto clientDto;
	private AppointmentDto appointmentDto;
	private BarberRepository barberRepository;

	@Before
	public void setUp(){
		clientService = new ClientService(clientFactory,clientRepository,barberRepository);
	}

	@Test
	public void whenCreatingANewUser_thenDelegateCreationToFactory()throws Exception{

		clientService.create(clientDto);

		verify(clientFactory).create(clientDto);
	}

	@Test
	public void whenMakingAnHairAppointment_thenDelegateFindingClientToRepo()throws Exception{
		clientService.makeHairAppointment(appointmentDto);

		verify(clientRepository).findClientByUsername(CLIENT_USERNAME);
	}

	@Test
	public void whenMakingAnHairAppointment_thenDelegateFindingBarberToRepo()throws Exception{

		clientService.makeHairAppointment(appointmentDto);

		verify(barberRepository).findBarberByUsername(BARBER_USERNAME);
	}



}
