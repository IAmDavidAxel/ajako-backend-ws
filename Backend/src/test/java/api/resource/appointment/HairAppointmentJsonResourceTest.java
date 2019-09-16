package api.resource.appointment;

import application.service.user.client.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HairAppointmentJsonResourceTest {



	private HairAppointmentJsonResource appointmentJsonResource;

	@Mock
	private ClientService clientService;
	private AppointmentDto AppointmentDto;

	@Before
	public void setUp(){
		appointmentJsonResource = new HairAppointmentJsonResource(clientService);
	}

	@Test
	public void whenCreatingANewAppointment_thenDelegateToService()throws Exception{
		appointmentJsonResource.makeHairAppointment(AppointmentDto );

		verify(clientService).makeHairAppointment(AppointmentDto);
	}
}
