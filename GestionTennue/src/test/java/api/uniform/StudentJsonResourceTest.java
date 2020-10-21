package api.uniform;

import api.dto.user.student.StudentDto;
import api.user.student.StudentJsonResource;
import application.service.user.student.StudentService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StudentJsonResourceTest {

	private StudentJsonResource studentJsonResource;

	@Mock
	private StudentService studentService;
	private StudentDto studentDto;


	@Before
	public void setUp() throws Exception{
		studentJsonResource = new StudentJsonResource(studentService);
	}


	@Test
	public void whenCreatingStudent_thenDelegateToService()throws Exception{
		studentJsonResource.create(studentDto);

		verify(studentService).create(studentDto);
	}

	@Test
	public void whenFetchingStudents_thenDelegateToService()throws Exception{
		studentJsonResource.getAllStudents();

		verify(studentService).getAll();
	}
}
