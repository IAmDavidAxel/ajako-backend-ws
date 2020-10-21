package infrastructure.persistence.repository;

import domain.user.student.Student;
import domain.user.student.StudentRepository;
import infrastructure.persistence.assembler.user.student.StudentAssembler;
import infrastructure.persistence.dao.DaoInternalException;
import infrastructure.persistence.dao.sqlite.builder.DaoEntityNotFoundException;
import infrastructure.persistence.dao.user.student.StudentDao;
import infrastructure.persistence.dto.StudentDto;
import infrastructure.persistence.exception.PersistenceInternalException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentSqliteRepository implements StudentRepository {

	private StudentAssembler studentAssembler;
	private StudentDao studentDao;

	public StudentSqliteRepository(StudentAssembler studentAssembler, StudentDao studentDao) {
		this.studentAssembler = studentAssembler;
		this.studentDao = studentDao;
	}

	@Override
	public void save(Student student) throws PersistenceInternalException {
		StudentDto studentDto = createDtoFromAssembler(student);
		saveStudent(studentDto);
	}

	@Override
	public List<Student> findAll() throws PersistenceInternalException {
		List<StudentDto> studentDtos= fetchingStudents();
		return creatingList(studentDtos);
	}

	private List<Student> creatingList(List<StudentDto> studentDtos) {
		return studentAssembler.createList(studentDtos);
	}

	private List<StudentDto> fetchingStudents() throws PersistenceInternalException{
		try{
			return studentDao.findAll();
		}catch (DaoInternalException | DaoEntityNotFoundException exception){
			Logger.getGlobal().log(Level.SEVERE,exception.getMessage());
			throw  new PersistenceInternalException();
		}
	}

	private void saveStudent(StudentDto studentDto) throws PersistenceInternalException {
		try{
			studentDao.save(studentDto);
		}catch (DaoInternalException exception){
			Logger.getGlobal().log(Level.SEVERE,exception.getMessage());
			throw  new PersistenceInternalException();
		}
	}

	private StudentDto createDtoFromAssembler(Student student) {
		return studentAssembler.create(student);
	}
}
