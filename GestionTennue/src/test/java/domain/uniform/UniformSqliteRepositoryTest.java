package domain.uniform;

import infrastructure.persistence.assembler.uniform.UniformAssembler;
import infrastructure.persistence.dao.uniform.UniformDao;
import infrastructure.persistence.dto.UniformDto;
import infrastructure.persistence.repository.UniformSqliteRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UniformSqliteRepositoryTest {

	private UniformSqliteRepository uniformSqliteRepository;

	@Mock
	private UniformAssembler uniformAssembler;
	@Mock
	private UniformDao uniformDao;
	private Uniform uniform;
	private UniformDto uniformDto;
	private List<UniformDto> uniformDtos;

	@Before
	public void setUp() throws Exception{
		uniformSqliteRepository = new UniformSqliteRepository(uniformAssembler,uniformDao);
		uniformDtos = new ArrayList<>();
		uniformDtos.add(uniformDto);
		willReturn(uniformDto).given(uniformAssembler).create(uniform);
		willReturn(uniformDtos).given(uniformDao).findAll();
	}

	@Test
	public void whenSavingUniform_thenDelegateAssemblyTransformationToAssembler()throws Exception{
		uniformSqliteRepository.save(uniform);

		verify(uniformAssembler).create(uniform);
	}

	@Test
	public void whenSavingUniform_thenDelegateActualSavingToTheDao()throws Exception{
		uniformSqliteRepository.save(uniform);

		verify(uniformDao).save(uniformDto);
	}

	@Test
	public void whenFindingAllUniform_thenDelegateFindingToDao()throws Exception{
		uniformSqliteRepository.findAll();

		verify(uniformDao).findAll();
	}

	@Test
	public void whenFindingAllUniform_thenDelegateTransformationToDomainObToTheAssembler()throws Exception{
		uniformSqliteRepository.findAll();

		verify(uniformAssembler).createList(uniformDtos);
	}
}
