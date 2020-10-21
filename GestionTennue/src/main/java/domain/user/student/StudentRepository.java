package domain.user.student;

import infrastructure.persistence.exception.PersistenceInternalException;

import java.util.List;

public interface StudentRepository {
	void save(Student student) throws PersistenceInternalException;

	List<Student> findAll() throws PersistenceInternalException;
}
