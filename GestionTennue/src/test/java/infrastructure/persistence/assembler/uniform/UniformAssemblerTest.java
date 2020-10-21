package infrastructure.persistence.assembler.uniform;

import domain.uniform.SousType;
import domain.uniform.Type;
import domain.uniform.Uniform;
import domain.uniform.UniformId;
import infrastructure.persistence.dto.UniformDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UniformAssemblerTest {

	private static final int A_SIZE = 45;
	private static final float A_PRICE = 5000F;
	private static final  Type A_TYPE = Type.TENUE_DE_SPORT ;
	private static final SousType SOUS_TYPE = SousType.PAGNE_DE_CHEMISE;

	private UniformAssembler uniformAssembler;

	private Uniform uniform;
	private UniformId uniformId;
	private UniformDto uniformDto;
	private List<UniformDto> uniformDtos;

	private void setUpDto(){
		uniformDto = new UniformDto();

		uniformDto.setSize(A_SIZE);
		uniformDto.setSousType(SOUS_TYPE);
		uniformDto.setType(A_TYPE);
		uniformDto.setPrice(A_PRICE);
	}
	@Before
	public void setUp(){
		setUpDto();
		uniformId = new UniformId();
		uniform = new Uniform(uniformId,A_SIZE,A_PRICE,A_TYPE,SOUS_TYPE);
		uniformDtos = new ArrayList<>();
		uniformDtos.add(uniformDto);
		uniformAssembler = new UniformAssembler();

	}

	@Test
	public void
	whenCreatingANewPersistenceObject_thenAllAttributesAreEquals(){
		UniformDto uniformDtoFromAssembler = uniformAssembler.create(uniform);

		String expectedIdFromAssembler = uniformId.getIdValue();

		String id = uniformDtoFromAssembler.getId();
		int size = uniformDtoFromAssembler.getSize();
		float price = uniformDtoFromAssembler.getPrice();
		Type type = uniformDtoFromAssembler.getType();
		SousType sousType = uniformDtoFromAssembler.getSousType();

		assertEquals(expectedIdFromAssembler,id);
		assertEquals(size,A_SIZE);
		assertEquals(price,A_PRICE,0);
		assertEquals(type,A_TYPE);
		assertEquals(sousType,SOUS_TYPE);
	}

	@Test
	public void whenCreatingNewDomainUniform_thenAllAttributesAreCorrect(){
		Uniform uniform = uniformAssembler.create(uniformDto);

		int size = uniform.getSize();
		float price = uniform.getPrice();
		Type type = uniform.getType();
		SousType sousType = uniform.getSousType();

		assertEquals(size,A_SIZE);
		assertEquals(price,A_PRICE,0);
		assertEquals(type,A_TYPE);
		assertEquals(sousType,SOUS_TYPE);
	}

	@Test
	public void whenCreatingAListOfDomainObjects_thenAllAttributesAreEquals(){
		List<Uniform> uniforms;

		uniforms = uniformAssembler.createList(uniformDtos);

		Uniform uniform = uniforms.get(0);

		int size = uniform.getSize();

		assertEquals(size,A_SIZE);
	}


}
