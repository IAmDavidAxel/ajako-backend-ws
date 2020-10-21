package infrastructure.persistence.repository;

import domain.user.student.Student;
import domain.user.student.StudentId;
import infrastructure.persistence.assembler.user.student.StudentAssembler;
import infrastructure.persistence.dao.user.student.StudentDao;
import infrastructure.persistence.dto.StudentDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StudentSqliteRepositoryTest {

	private static final String NAME = "Karim";
	private static final String LAST_NAME = "Benzema";
	private static final String DATE_OF_BIRTH = "11/05/2004";
	private static final String PLACE_OF_BIRTH = "bobo";
	private static final String SEX = "male";
	private static final String NATIONALITY = "burkinabé";
	private static final String SIT_SANIT = ":/";
	private static final String ADDRESS = "Ouidi";
	private static final String TYPE = ":/";
	private static final String FATHER_PHONE_NUMBER = "78-98-98-98";
	private static final String FATHER_CELL_PHONE_NUMBER = "55-89-89-89";
	private static final String MOTHER_PHONE_NUMBER = "78-78-78-78";
	private static final String MOTHER_CELL_PHONE_NUMBER = "78-78-78-78";
	private static final String TUTOR = "Zidane";
	private static final String TUTOR_PHONE_NUMBER = "7878788";
	private static final String PHONE_NUMBER = "789789798";
	private static final String ID_VALUE = "sqd7899-7s8d7s";
	private static final String MATRICULE = "7987884m";

	private StudentSqliteRepository studentSqliteRepository;

	private Student student;

	@Mock
	private StudentAssembler studentAssembler;
	@Mock
	private StudentDao studentDao;
	@Mock
	private StudentId  studentId;
	private StudentDto studentDto;

	@Before
	public void setUp()throws Exception{
		student = new Student(studentId,NAME,LAST_NAME, MATRICULE, DATE_OF_BIRTH,PLACE_OF_BIRTH,SEX,PHONE_NUMBER,NATIONALITY,SIT_SANIT,ADDRESS,TYPE,FATHER_PHONE_NUMBER,FATHER_CELL_PHONE_NUMBER,MOTHER_CELL_PHONE_NUMBER,MOTHER_PHONE_NUMBER,TUTOR,TUTOR_PHONE_NUMBER);
		studentSqliteRepository = new StudentSqliteRepository(studentAssembler,studentDao);
		willReturn(studentDto).given(studentAssembler).create(student);
	}

	@Test
	public void whenSavingANewStudent_thenDelegateTransformationToAssembler()throws Exception{
		studentSqliteRepository.save(student);

		verify(studentAssembler).create(student);
	}

	@Test
	public void whenSavingANewStudent_thenDelegateActualSavingToDao()throws Exception{
		studentSqliteRepository.save(student);

		verify(studentDao).save(studentDto);
	}

	@Test
	public void whenFetchingAllStudents_thenDelegateFindingToTheDao()throws Exception{
		studentSqliteRepository.findAll();

		verify(studentDao).findAll();
	}



}
