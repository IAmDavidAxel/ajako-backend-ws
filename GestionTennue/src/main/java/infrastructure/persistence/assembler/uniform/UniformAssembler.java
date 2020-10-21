package infrastructure.persistence.assembler.uniform;

import domain.uniform.SousType;
import domain.uniform.Type;
import domain.uniform.Uniform;
import domain.uniform.UniformId;
import infrastructure.persistence.dto.UniformDto;

import java.util.List;
import java.util.stream.Collectors;

public class UniformAssembler {


	public UniformDto create(Uniform uniform) {
		UniformDto uniformDto = new UniformDto();

		uniformDto.setPrice(uniform.getPrice());
		uniformDto.setSize(uniform.getSize());
		uniformDto.setSousType(uniform.getSousType());
		uniformDto.setType(uniform.getType());
		uniformDto.setId(uniform.getUniformId().getIdValue());

		return uniformDto;
	}

	public Uniform create(UniformDto uniformDto) {
		String id = uniformDto.getId();
		int size = uniformDto.getSize();
		float price = uniformDto.getPrice();
		Type type = uniformDto.getType();
		SousType sousType = uniformDto.getSousType();

		UniformId uniformId = new UniformId();
		uniformId.setId(id);

		return new Uniform(uniformId,size,price,type,sousType);
	}


	public List<Uniform> createList(List<UniformDto> uniformDtos) {
		return uniformDtos.stream().map(this::create).collect(Collectors.toList());
	}


}
