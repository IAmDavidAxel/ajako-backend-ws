package domain.uniform;

import api.dto.uniform.UniformDto;

import java.util.List;
import java.util.stream.Collectors;

public class UniformFactory {


	private UniformIdFactory uniformIdFactory;

	public UniformFactory(UniformIdFactory uniformIdFactory) {

		this.uniformIdFactory = uniformIdFactory;
	}

	public Uniform create(UniformDto uniformDto) {
		int size = uniformDto.getSize();
		float price = uniformDto.getPrice();
		Type type = uniformDto.getType();
		SousType sousType = uniformDto.getSousType();

		UniformId uniformId = uniformIdFactory.create();

		return new Uniform(uniformId,size,price,type,sousType);
	}

	public UniformDto create(Uniform uniform) {
		UniformDto uniformDto = new UniformDto();

		uniformDto.setPrice(uniform.getPrice());
		uniformDto.setSize(uniform.getSize());
		uniformDto.setSousType(uniform.getSousType());
		uniformDto.setType(uniform.getType());

		return uniformDto;
	}



	public List<UniformDto> createList(List<Uniform> uniforms) {
		return uniforms.stream().map(this::create).collect(Collectors.toList());
	}
}

