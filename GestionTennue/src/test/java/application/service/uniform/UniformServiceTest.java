package application.service.uniform;

import api.dto.uniform.UniformDto;
import domain.uniform.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.xml.ws.Service;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UniformServiceTest{
	private static final int A_SIZE = 45;
	private static final float A_PRICE = 5000F;
	private static final Type A_TYPE = Type.TENUE_DE_SPORT ;
	private static final SousType SOUS_TYPE = SousType.PAGNE_DE_CHEMISE;

	private UniformService uniformService;

	@Mock
	private UniformRepository uniformRepository;
	@Mock
	private UniformFactory uniformFactory;
	private UniformDto uniformDto;
	private Uniform uniform;
	private List<Uniform> uniforms;
	private UniformId uniformId;
	private List<UniformDto> uniformDtos;

	private void setUpDto(){
		uniformDto = new UniformDto();

		uniformDto.setSize(A_SIZE);
		uniformDto.setPrice(A_PRICE);
		uniformDto.setType(A_TYPE);
		uniformDto.setSousType(SOUS_TYPE);
	}

	@Before
	public void setUp() throws Exception{
		uniformId = new UniformId();
		setUpDto();
		uniform = new Uniform(uniformId,A_SIZE,A_PRICE,A_TYPE,SOUS_TYPE);
		uniforms = new ArrayList<>();
		uniforms.add(uniform);
		uniformService = new UniformService(uniformRepository,uniformFactory);
		willReturn(uniforms).given(uniformRepository).findAll();
		willReturn(uniform).given(uniformFactory).create(uniformDto);
		willReturn(uniformDtos).given(uniformFactory).createList(uniforms);
	}

	@Test
	public void whenCreatingANewUniform_thenDelegateTransformationToFactory()throws Exception{
		uniformService.create(uniformDto);

		verify(uniformFactory).create(uniformDto);
	}

	@Test
	public void whenCreatingANewUniform_thenDelegateSavingToTheRepo()throws Exception{
		uniformService.create(uniformDto);

		verify(uniformRepository).save(uniform);
	}

	@Test
	public void whenGettingAllUniforms_thenDelegateToRepo()throws Exception{
		uniformService.getAll();

		verify(uniformRepository).findAll();
	}

	@Test
	public void whenGettingAllUniforms_thenDelegateTransformationToFactory()throws Exception{
		uniformService.getAll();

		verify(uniformFactory).createList(uniforms);
	}
}
