package domain.uniform;

import infrastructure.persistence.exception.PersistenceInternalException;

import java.util.List;

public interface UniformRepository {
	void save(Uniform uniform) throws PersistenceInternalException;

	List<Uniform> findAll() throws PersistenceInternalException;
}
