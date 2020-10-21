package application.service.user.student;

import api.dto.user.student.StudentDto;
import domain.user.student.Student;
import domain.user.student.StudentFactory;
import domain.user.student.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

	private StudentService studentService;

	@Mock
	private StudentFactory studentFactory;
	@Mock
	private StudentRepository studentRepository;
	private StudentDto studentDto;
	private Student student;
	private List<StudentDto> studentDtos;
	private List<Student> students;


	@Before
	public void setUp() throws Exception{
		studentService = new StudentService(studentFactory,studentRepository);
		willReturn(student).given(studentFactory).create(studentDto);
		willReturn(students).given(studentRepository).findAll();

	}

	@Test
	public void whenCreatingANewStudent_thenDelegateCreationToFactory()throws Exception{
		studentService.create(studentDto);

		verify(studentFactory).create(studentDto);
	}

	@Test
	public void whenCreatingANewStudent_thenDelegateSavingToTheRepo()throws Exception{
		studentService.create(studentDto);

		verify(studentRepository).save(student);
	}

	@Test
	public void whenFetchingAllStudents_thenDelegateSearchingToTheServices()throws Exception{
		studentService.getAll();

		verify(studentRepository).findAll();
	}

	@Test
	public void whenFetchingAllStudents_thenDelegateTransformationToFactory()throws Exception{
		studentService.getAll();

		verify(studentFactory).createList(students);
	}
}
