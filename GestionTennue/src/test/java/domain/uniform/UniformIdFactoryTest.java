package domain.uniform;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniformIdFactoryTest {

	private UniformIdFactory uniformIdFactory;

	@Before
	public void setUp(){
		uniformIdFactory = new UniformIdFactory();
	}

	@Test
	public void whenCreatingANewId_thenItsNotNull(){
		UniformId uniformId = uniformIdFactory.create();

		assertNotNull(uniformId);
	}

}
