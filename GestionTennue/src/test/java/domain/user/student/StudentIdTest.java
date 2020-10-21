package domain.user.student;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentIdTest {

	private StudentId studentId;

	@Before
	public void setUp(){
		studentId = new StudentId();
	}

	@Test
	public void whenCreatingANewId_thenIdValueIsNotNullUUIDValue(){
		String idValue = studentId.getIdValue();

		assertNotNull(idValue);
		System.out.println(idValue);
	}

	@Test
	public void whenCreatingTwoIdObject_thenTheyHaveDifferentValues(){
		String firstIdValue = studentId.getIdValue();
		StudentId secondId = new StudentId();
		String secondIdValue = secondId.getIdValue();

		assertNotEquals(secondIdValue,firstIdValue);
		System.out.println(firstIdValue + " and" + secondIdValue);
	}

}
