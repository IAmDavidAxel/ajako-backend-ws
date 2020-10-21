package domain.user.student;

import api.dto.user.student.StudentDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;

@RunWith(MockitoJUnitRunner.class)
public class StudentFactoryTest {

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
	private static final String MATRICULE = "898sdf";
	private StudentFactory studentFactory;

	private Student student;
	private StudentDto studentDto;
	private List<Student> students;


	@Mock
	private StudentIdFactory studentIdFactory;
	@Mock
	private StudentId studentId;

	private void setUpDto(){
		studentDto = new StudentDto();

		studentDto.setName(NAME);
		studentDto.setLastName(LAST_NAME);
		studentDto.setDateOfBirth(DATE_OF_BIRTH);
		studentDto.setPlaceOfBirth(PLACE_OF_BIRTH);
		studentDto.setSex(SEX);
		studentDto.setNationality(NATIONALITY);
		studentDto.setSitSanit(SIT_SANIT);
		studentDto.setAddress(ADDRESS);
		studentDto.setType(TYPE);
		studentDto.setFatherPhoneNumber(FATHER_PHONE_NUMBER);
		studentDto.setFatherCellPhoneNUmber(FATHER_CELL_PHONE_NUMBER);
		studentDto.setMotherPhoneNumber(MOTHER_PHONE_NUMBER);
		studentDto.setMotherCellPhoneNumber(MOTHER_CELL_PHONE_NUMBER);
		studentDto.setTutor(TUTOR);
		studentDto.setTutorPhoneNumber(TUTOR_PHONE_NUMBER);
		studentDto.setPhoneNumber(PHONE_NUMBER);
	}

	@Before
	public void setUp(){
		setUpDto();
		student = new Student(studentId,NAME,LAST_NAME, MATRICULE, DATE_OF_BIRTH,PLACE_OF_BIRTH,SEX,PHONE_NUMBER,NATIONALITY,SIT_SANIT,ADDRESS,TYPE,FATHER_PHONE_NUMBER,FATHER_CELL_PHONE_NUMBER,MOTHER_CELL_PHONE_NUMBER,MOTHER_PHONE_NUMBER,TUTOR,TUTOR_PHONE_NUMBER);
		students = new ArrayList<>();
		students.add(student);
		studentFactory = new StudentFactory(studentIdFactory);
		willReturn(ID_VALUE).given(studentId).getIdValue();
		willReturn(studentId).given(studentIdFactory).create();
	}

	@Test
	public void whenCreatingStudentFromDto_thenAllAttributesAreEqual(){
		Student student = studentFactory.create(studentDto);

		assertEquals(NAME,student.getName());
		assertEquals(LAST_NAME,student.getLastName());
		assertEquals(DATE_OF_BIRTH,student.getDateOfBirth());
		assertEquals(PLACE_OF_BIRTH,student.getPlaceOfBirth());
		assertEquals(PHONE_NUMBER,student.getPhoneNumber());
		assertEquals(NATIONALITY,student.getNationality());
		assertEquals(SIT_SANIT,student.getSanitarySituation());
		assertEquals(ADDRESS,student.getAddress());
		assertEquals(TYPE,student.getType());
		assertEquals(FATHER_PHONE_NUMBER,student.getFatherPhoneNumber());
		assertEquals(FATHER_CELL_PHONE_NUMBER,student.getFatherCellPhoneNumber());
		assertEquals(MOTHER_CELL_PHONE_NUMBER,student.getMotherCellPhoneNumber());
		assertEquals(MOTHER_PHONE_NUMBER,student.getMotherPhoneNumber());
		assertEquals(TUTOR,student.getTutor());
		assertEquals(TUTOR_PHONE_NUMBER,student.getTutorPhoneNumber());
	}

	@Test
	public void whenCreatingDto_thenAllAttributesAreEqual(){
		StudentDto studentDto = studentFactory.create(student);

		assertEquals(NAME,studentDto.getName());
		assertEquals(LAST_NAME,studentDto.getLastName());
		assertEquals(DATE_OF_BIRTH,studentDto.getDateOfBirth());
		assertEquals(PLACE_OF_BIRTH,studentDto.getPlaceOfBirth());
		assertEquals(PHONE_NUMBER,studentDto.getPhoneNumber());
		assertEquals(NATIONALITY,studentDto.getNationality());
		assertEquals(SIT_SANIT,studentDto.getSitSanit());
		assertEquals(ADDRESS,studentDto.getAddress());
		assertEquals(TYPE,studentDto.getType());
		assertEquals(FATHER_PHONE_NUMBER,studentDto.getFatherPhoneNumber());
		assertEquals(FATHER_CELL_PHONE_NUMBER,studentDto.getFatherCellPhoneNumber());
		assertEquals(MOTHER_CELL_PHONE_NUMBER,studentDto.getMotherCellPhoneNumber());
		assertEquals(MOTHER_PHONE_NUMBER,studentDto.getMotherPhoneNumber());
		assertEquals(TUTOR,studentDto.getTutor());
		assertEquals(TUTOR_PHONE_NUMBER,studentDto.getTutorPhoneNumber());
	}

	@Test
	public void whenTransformingAListOfStudentDto_thenTheFetchObjectHasCorrectValues(){
		List<StudentDto> studentDtos = studentFactory.createList(students);

		StudentDto studentDto = studentDtos.get(0);

		String name = studentDto.getName();

		assertEquals(NAME,name);
	}


}
