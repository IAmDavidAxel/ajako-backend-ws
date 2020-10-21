package api.uniform;

import api.dto.uniform.UniformDto;
import application.service.uniform.UniformService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UniformJsonResourceTest {

	private UniformJsonResource uniformJsonResource;
	@Mock
	private UniformService uniformService;
	private UniformDto uniformDto;

	@Before
	public void setUp(){
		uniformJsonResource = new UniformJsonResource(uniformService);
	}

	@Test
	public void whenCreatingAnUni_thenDelegateToService()throws Exception{
		uniformJsonResource.create(uniformDto);

		verify(uniformService).create(uniformDto);
	}

	@Test
	public void whenGettingAllNewUniform_thenDelegateToService()throws Exception{
		uniformJsonResource.getAllUniforms();

		verify(uniformService).getAll();
	}
}
