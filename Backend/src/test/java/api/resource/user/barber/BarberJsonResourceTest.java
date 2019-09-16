package api.resource.user.barber;

import application.service.exception.ServiceException;
import application.service.user.barber.BarberService;
import application.service.user.manager.ManagerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BarberJsonResourceTest {

	private  BarberJsonResource barberJsonResource;

	@Mock
	private BarberService barberService;
	private BarberDto barberDto;
	@Mock
	private ManagerService managerService;

	@Before
	public void setUp(){
		barberJsonResource = new BarberJsonResource(barberService,managerService);
	}

	@Test
	public void whenCreatingANewBarber_thenDelegateToService()throws ServiceException{

		barberJsonResource.createBarber(barberDto);

		verify(barberService).create(barberDto);
	}

	@Test
	public void whenCreatingANewBarber_thenDelegateToManagerService()throws ServiceException {

		barberJsonResource.createDriverByManager(barberDto);

		verify(managerService).create(barberDto);
	}

}
