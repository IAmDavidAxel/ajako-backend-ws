package application.service.user.client;



import api.dto.user.client.ClientDto;
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

	private ClientService clientService;

	@Mock
	private ClientFactory clientFactory;
	@Mock
	private ClientRepository clientRepository;
	private ClientDto clientDto;

	@Before
	public void setUp(){
		clientService = new ClientService(clientFactory,clientRepository);
	}

	@Test
	public void whenCreatingANewUser_thenDelegateCreationToFactory()throws Exception{

		clientService.create(clientDto);

		verify(clientFactory).create(clientDto);
	}



}
