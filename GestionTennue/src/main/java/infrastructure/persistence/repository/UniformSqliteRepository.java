package infrastructure.persistence.repository;

import domain.uniform.Uniform;
import domain.uniform.UniformRepository;
import infrastructure.persistence.assembler.uniform.UniformAssembler;
import infrastructure.persistence.dao.DaoInternalException;
import infrastructure.persistence.dao.sqlite.builder.DaoEntityNotFoundException;
import infrastructure.persistence.dao.uniform.UniformDao;
import infrastructure.persistence.dto.UniformDto;
import infrastructure.persistence.exception.PersistenceInternalException;

import java.util.List;

public class UniformSqliteRepository implements UniformRepository {

	private UniformAssembler uniformAssembler;
	private UniformDao uniformDao;

	public UniformSqliteRepository(UniformAssembler uniformAssembler, UniformDao uniformDao) {
		this.uniformAssembler = uniformAssembler;
		this.uniformDao = uniformDao;
	}

	@Override
	public void save(Uniform uniform) throws PersistenceInternalException {
		UniformDto uniformDto = createFromAssembler(uniform);
		saveUni(uniformDto);
	}

	@Override
	public List<Uniform> findAll() throws PersistenceInternalException {
		List<UniformDto> uniformDtos = findAllDtos();
		return createListOfUniforms(uniformDtos);
	}

	private List<Uniform> createListOfUniforms(List<UniformDto> uniformDtos) {
		return uniformAssembler.createList(uniformDtos);
	}

	private List<UniformDto> findAllDtos() throws PersistenceInternalException {
		try {
			return uniformDao.findAll();
		}catch (DaoInternalException| DaoEntityNotFoundException e){
			throw  new PersistenceInternalException();
		}
	}

	private void saveUni(UniformDto uniformDto) throws PersistenceInternalException  {
		try {
			uniformDao.save(uniformDto);
		}catch (DaoInternalException e){
			throw new PersistenceInternalException();
		}

	}

	private UniformDto createFromAssembler(Uniform uniform) {
		return uniformAssembler.create(uniform);
	}
}
