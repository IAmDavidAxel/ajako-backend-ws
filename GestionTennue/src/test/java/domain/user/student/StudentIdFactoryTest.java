package domain.user.student;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentIdFactoryTest {

	private StudentIdFactory studentIdFactory;
	private StudentId studentId;

	@Before
	public void setUp(){
		studentIdFactory = new StudentIdFactory();
	}

	@Test
	public void whenCreatingANewIdObject_thenItsNotNull(){
		studentId = studentIdFactory.create();

		assertNotNull(studentId);
	}

}
