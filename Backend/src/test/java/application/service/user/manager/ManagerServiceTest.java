package application.service.user.manager;

import api.resource.haircut.HaircutDto;
import api.resource.user.barber.BarberDto;
import application.service.haircut.HaircutAssembler;
import domain.haircut.Haircut;
import domain.haircut.HaircutRepository;
import domain.user.barber.Barber;
import domain.user.barber.BarberFactory;
import domain.user.barber.BarberRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ManagerServiceTest {

	private static final String USERNAME = "kaka";
	private static final String PASSWORD_VALUE = "popo";
	private static final String FIRST_NAME = "kady";
	private static final String LAST_NAME = "jolie";
	private static final String HAIRCUT_NAME = "luz clarita";
	private static final float HAIRCUT_PRICE = 18;

	private ManagerService managerService;
	private BarberDto barberDto;
	@Mock
	private BarberFactory barberFactory;
	@Mock
	private Barber barber;
	@Mock
	private BarberRepository barberRepository;
	private HaircutDto haircutDto;
	@Mock
	private HaircutAssembler haircutAssembler;
	private Haircut haircut;
	@Mock
	private HaircutRepository haircutRepository;

	private void setUpDto(){
		barberDto = new BarberDto();

		barberDto.setUsername(USERNAME);
		barberDto.setPasswordValue(PASSWORD_VALUE);
		barberDto.setFirstName(FIRST_NAME);
		barberDto.setLastName(LAST_NAME);

		haircutDto = new HaircutDto();

		haircutDto.setName(HAIRCUT_NAME);
		haircutDto.setPrice(HAIRCUT_PRICE);
	}

	@Before
	public void setUp(){
		setUpDto();
		managerService = new ManagerService(barberFactory,barberRepository,haircutAssembler,haircutRepository);
		haircut = new Haircut(HAIRCUT_NAME,HAIRCUT_PRICE);
	}

	@Test
	public void whenCreatingANewBarber_thenDelegateToBarberFactory()throws Exception{

		managerService.create(barberDto);

		verify(barberFactory).create(barberDto);
	}

	@Test
	public void whenCreatingANewBarber_thenDelegateSavingToBarberRepository()throws Exception{
		willReturn(barber).given(barberFactory).create(barberDto);

		managerService.create(barberDto);

		verify(barberRepository).save(barber);
	}

	@Test
	public void whenCreatingANewHaircut_thenDelegateCreationToAssembler()throws Exception{

		managerService.create(haircutDto);

		verify(haircutAssembler).assemble(haircutDto);
	}

	@Test
	public void whenCreatingANewHaircut_thenDelegateSavingToTheRepo()throws Exception{

		willReturn(haircut).given(haircutAssembler).assemble(haircutDto);

		managerService.create(haircutDto);

		verify(haircutRepository).save(haircut);


	}


}
