package infrastructure.persistence.dao.user.student;

import infrastructure.persistence.dao.DaoInternalException;
import infrastructure.persistence.dao.sqlite.builder.DaoEntityNotFoundException;
import infrastructure.persistence.dto.StudentDto;

import java.util.List;

public interface StudentDao {
	void save(StudentDto studentDto) throws DaoInternalException;

	List<StudentDto> findAll() throws DaoInternalException, DaoEntityNotFoundException;
}
