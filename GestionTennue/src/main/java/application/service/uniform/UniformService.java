package application.service.uniform;

import api.dto.uniform.UniformDto;
import application.service.exception.PersistenceInternalServiceException;
import application.service.exception.ServiceException;
import domain.uniform.Uniform;
import domain.uniform.UniformFactory;
import domain.uniform.UniformRepository;
import infrastructure.persistence.exception.PersistenceInternalException;

import java.util.List;

public class UniformService {
	private  UniformRepository uniformRepository;
	private  UniformFactory uniformFactory;

	public UniformService(UniformRepository uniformRepository, UniformFactory uniformFactory) {
		this.uniformRepository = uniformRepository;
		this.uniformFactory = uniformFactory;
	}

	public void create(UniformDto uniformDto) throws ServiceException {
		Uniform uniform = createUniFromFactory(uniformDto);
		save(uniform);
	}

	public List<UniformDto> getAll() throws ServiceException {
		List<Uniform> uniforms = getUniformsFromRepo();
		return createUniForDisplay(uniforms);
	}

	private List<UniformDto> createUniForDisplay(List<Uniform> uniforms) {
		return uniformFactory.createList(uniforms);
	}

	private List<Uniform> getUniformsFromRepo() throws ServiceException {
		try{
			return uniformRepository.findAll();
		}catch (PersistenceInternalException exception){
			throw  new PersistenceInternalServiceException();
		}
	}

	private void save(Uniform uniform) throws ServiceException {
		try{
			uniformRepository.save(uniform);
		}catch (PersistenceInternalException e){
			throw new PersistenceInternalServiceException();
		}
	}

	private Uniform createUniFromFactory(UniformDto uniformDto) {
		return uniformFactory.create(uniformDto);
	}
}
