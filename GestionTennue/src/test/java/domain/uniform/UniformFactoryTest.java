package domain.uniform;

import api.dto.uniform.UniformDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;

@RunWith(MockitoJUnitRunner.class)
public class UniformFactoryTest {

	private static final int A_SIZE = 45;
	private static final float A_PRICE = 5000F;
	private static final  Type A_TYPE = Type.TENUE_DE_SPORT ;
	private static final SousType SOUS_TYPE = SousType.PAGNE_DE_CHEMISE;
	private UniformFactory uniformFactory;
	private Uniform uniform;
	private UniformDto uniformDto;

	@Mock
	private UniformIdFactory uniformIdFactory;
	@Mock
	private UniformId uniformId;
	private List<Uniform> uniforms;

	private void setUpDto(){
		uniformDto = new UniformDto();

		uniformDto.setSize(A_SIZE);
		uniformDto.setPrice(A_PRICE);
		uniformDto.setType(A_TYPE);
		uniformDto.setSousType(SOUS_TYPE);
	}


	@Before
	public void setUp(){
		willReturn(uniformId).given(uniformIdFactory).create();
		setUpDto();
		uniform = new Uniform(uniformId,A_SIZE,A_PRICE,A_TYPE,SOUS_TYPE);
		uniforms = new ArrayList<>();
		uniforms.add(uniform);
		uniformFactory = new UniformFactory(uniformIdFactory);
	}

	@Test
	public void whenCreatingANewUniform_thenAllAttributesAreEquals(){
		Uniform uniformFromFactory =uniformFactory.create(uniformDto);

		int sizeFromFactory = uniformFromFactory.getSize();
		float price = uniformFromFactory.getPrice();
		String type = uniformFromFactory.getType().toString();
		String sousType = uniformFromFactory.getSousType().toString();
		String idUniForm = uniformId.getIdValue();
		String idFromFactory = uniformFromFactory.getUniformId().getIdValue();

		assertEquals(sizeFromFactory,A_SIZE);
		assertEquals(price,A_PRICE,0);
		assertEquals(type,A_TYPE.toString());
		assertEquals(sousType,SOUS_TYPE.toString());
		assertEquals(idUniForm,idFromFactory);
	}

	@Test
	public void whenCreatingDtoObjects_thenAllAttributesAreEquals(){
		UniformDto uniformDto = uniformFactory.create(uniform);

		float price = uniformDto.getPrice();
		int size = uniformDto.getSize();
		Type type = uniformDto.getType();
		SousType sousType = uniformDto.getSousType();

		assertEquals(price,A_PRICE,0);
		assertEquals(size,A_SIZE);
		assertEquals(type,A_TYPE);
		assertEquals(sousType,SOUS_TYPE);
	}

	@Test
	public void whenCreatingListOfDtos_thenUniInTheListHasCorrectAttributes(){
		List<UniformDto> uniformDtos = uniformFactory.createList(uniforms);

		UniformDto uniformDto = uniformDtos.get(0);

		float price = uniformDto.getPrice();

		assertEquals(price,A_PRICE,0);
	}

}
