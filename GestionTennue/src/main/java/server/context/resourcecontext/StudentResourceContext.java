package server.context.resourcecontext;

import api.user.student.StudentJsonResource;
import api.user.student.StudentResource;
import application.service.user.student.StudentService;
import domain.user.student.StudentFactory;
import domain.user.student.StudentIdFactory;
import domain.user.student.StudentRepository;
import utility.servicelocator.ServiceLocator;

public class StudentResourceContext {

	public static StudentResource create(){
		StudentIdFactory studentIdFactory = new StudentIdFactory();
		StudentFactory studentFactory = new StudentFactory(studentIdFactory);
		StudentRepository studentRepository = ServiceLocator.INSTANCE.resolve(StudentRepository.class);

		StudentService studentService = new StudentService(studentFactory,studentRepository);

		return new StudentJsonResource(studentService);
	}
}
