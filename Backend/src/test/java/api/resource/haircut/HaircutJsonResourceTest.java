package api.resource.haircut;

import application.service.user.barber.BarberService;
import application.service.user.manager.ManagerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HaircutJsonResourceTest {

	private HaircutJsonResource haircutJsonResource;

	@Mock
	private ManagerService managerService;
	@Mock
	private BarberService barberService;
	private HaircutDto haircutDto;

	@Before
	public void setUp(){

		haircutJsonResource = new HaircutJsonResource(barberService, managerService);
	}

	@Test
	public void whenCreatingANewHaircut_thenDelegateToService()throws Exception{

		haircutJsonResource.create(haircutDto);

		verify(managerService).create(haircutDto);

	}

}
