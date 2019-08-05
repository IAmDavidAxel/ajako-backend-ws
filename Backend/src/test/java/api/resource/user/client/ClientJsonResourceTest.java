package api.resource.user.client;

import api.dto.user.client.ClientDto;
import application.service.user.client.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ClientJsonResourceTest {

	private ClientJsonResource clientResource;

	@Mock
	private ClientService clientService;
	private ClientDto clientDto;


	@Before
	public void setUp(){

		clientResource = new ClientJsonResource(clientService);
	}

	@Test
	public void whenCreatingANewClient_thenDelegateToService() throws Exception {

		clientResource.create(clientDto);

		verify(clientService).create(clientDto);

	}
}
