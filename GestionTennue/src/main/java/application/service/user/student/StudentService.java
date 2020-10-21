package application.service.user.student;

import api.dto.user.student.StudentDto;
import application.service.exception.PersistenceInternalServiceException;
import application.service.exception.ServiceException;
import domain.user.student.Student;
import domain.user.student.StudentFactory;
import domain.user.student.StudentRepository;
import infrastructure.persistence.exception.PersistenceInternalException;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentService {

	private StudentFactory studentFactory;
	private StudentRepository studentRepository;

	public StudentService(StudentFactory studentFactory, StudentRepository studentRepository) {

		this.studentFactory = studentFactory;
		this.studentRepository = studentRepository;
	}

	public void create(StudentDto studentDto) throws ServiceException {
		Student student = createStudentFromFactory(studentDto);
		save(student);
	}

	private void save(Student student) throws ServiceException{
		try{
			studentRepository.save(student);
		}catch (PersistenceInternalException exception){
			Logger.getGlobal().log(Level.SEVERE, exception.getMessage());
			throw new PersistenceInternalServiceException();
		}
	}

	private Student createStudentFromFactory(StudentDto studentDto) {
		return studentFactory.create(studentDto);
	}

	public List<StudentDto> getAll() throws ServiceException {
		List<Student> students = fetchingStudents();
		return creatingStudentsDto(students);
	}

	private List<StudentDto> creatingStudentsDto(List<Student> students) {
		return studentFactory.createList(students);
	}

	private List<Student> fetchingStudents() throws ServiceException{
		try{
			return studentRepository.findAll();
		}catch (PersistenceInternalException exception){
			Logger.getGlobal().log(Level.SEVERE,exception.getMessage());
			throw  new PersistenceInternalServiceException();
		}
	}
}
