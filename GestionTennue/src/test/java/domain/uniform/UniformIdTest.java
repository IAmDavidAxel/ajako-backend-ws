package domain.uniform;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniformIdTest {

	private UniformId uniformId;

	@Before
	public void setUp(){
		uniformId = new UniformId();
	}

	@Test
	public void atInstanciationTheIdIsCreated(){
		String id = uniformId.getIdValue();

		assertNotNull(id);
		System.out.println(id);
	}

	@Test
	public void whenCreatingTwoObjects_thenTheIdValuesAreDifferrent(){
		UniformId secondId = new UniformId();

		String firstIdValue = uniformId.getIdValue();
		String secondIdValue = secondId.getIdValue();

		assertNotEquals(firstIdValue,secondIdValue);
	}

}
