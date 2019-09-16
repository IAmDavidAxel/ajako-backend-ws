package domain.user.barber;

import infrastructure.repository.credential.PersistenceInternalException;
import infrastructure.repository.user.barber.BarberNotFoundException;

public interface BarberRepository {
	void save(Barber barber) throws PersistenceInternalException;

	Barber findBarberByUsername(String barberUsername) throws BarberNotFoundException  (barberUsername);
}
