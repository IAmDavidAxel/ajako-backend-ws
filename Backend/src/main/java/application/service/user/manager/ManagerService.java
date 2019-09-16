package application.service.user.manager;

import api.resource.haircut.HaircutDto;
import api.resource.user.barber.BarberDto;
import application.exception.EntityCreationServiceException;
import application.service.authentication.PersistenceInternalServiceException;
import application.service.exception.ServiceException;
import application.service.haircut.HaircutAssembler;
import domain.haircut.Haircut;
import domain.haircut.HaircutRepository;
import domain.password.IllegalPasswordFormatException;
import domain.user.InvalidUserNameException;
import domain.user.barber.Barber;
import domain.user.barber.BarberFactory;
import domain.user.barber.BarberRepository;
import infrastructure.repository.credential.PersistenceInternalException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ManagerService {

	private BarberFactory barberFactory;
	private BarberRepository barberRepository;
	private HaircutAssembler haircutAssembler;
	private HaircutRepository haircutRepository;

	public ManagerService(BarberFactory barberFactory, BarberRepository barberRepository, HaircutAssembler haircutAssembler, HaircutRepository haircutRepository) {

		this.barberFactory = barberFactory;
		this.barberRepository = barberRepository;
		this.haircutAssembler = haircutAssembler;
		this.haircutRepository = haircutRepository;
	}

	public void create(BarberDto barberDto) throws ServiceException {

		Barber barber = creatingBarberFromFactory(barberDto);

		saveBarber(barber);
	}

	private void saveBarber(Barber barber)  throws ServiceException{

		try{
			barberRepository.save(barber);
		}catch (PersistenceInternalException e){
			throw  new PersistenceInternalServiceException();
		}
	}

	private Barber creatingBarberFromFactory(BarberDto barberDto) throws ServiceException{

		try {
			 return barberFactory.create(barberDto);
		}catch (IllegalPasswordFormatException| InvalidUserNameException e ){
			Logger.getGlobal().log(Level.SEVERE,e.getMessage());
			throw  new EntityCreationServiceException(e);
		}

	}

	public void create(HaircutDto haircutDto) throws ServiceException {

		Haircut haircut = creatingHaircutFromAssembler(haircutDto);
		saveHaircut(haircut);
	}

	private void saveHaircut(Haircut haircut)  throws ServiceException{

		try{
			haircutRepository.save(haircut);
		}catch (PersistenceInternalException e){
			Logger.getGlobal().log(Level.SEVERE,e.getMessage());
			throw  new PersistenceInternalServiceException();
		}
	}

	private Haircut creatingHaircutFromAssembler(HaircutDto haircutDto) {
		return haircutAssembler.assemble(haircutDto);
	}
}
