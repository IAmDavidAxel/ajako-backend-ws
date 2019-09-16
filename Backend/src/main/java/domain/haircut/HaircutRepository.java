package domain.haircut;

import infrastructure.repository.credential.PersistenceInternalException;

public interface HaircutRepository {

	void save(Haircut haircut) throws PersistenceInternalException;
}
