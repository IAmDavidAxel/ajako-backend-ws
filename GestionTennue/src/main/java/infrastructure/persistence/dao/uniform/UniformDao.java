package infrastructure.persistence.dao.uniform;

import infrastructure.persistence.dao.DaoInternalException;
import infrastructure.persistence.dao.sqlite.builder.DaoEntityNotFoundException;
import infrastructure.persistence.dto.UniformDto;

import java.util.List;

public interface UniformDao {
	void save(UniformDto uniformDto) throws DaoInternalException;

	List<UniformDto> findAll() throws DaoInternalException, DaoEntityNotFoundException;
}
