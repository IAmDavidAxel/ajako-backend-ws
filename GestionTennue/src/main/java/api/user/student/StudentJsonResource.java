package api.user.student;

import api.dto.ResponseDto;
import api.dto.user.student.StudentDto;
import api.response.ResponseDtoBuilder;
import application.service.exception.ServiceException;
import application.service.user.student.StudentService;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;

public class StudentJsonResource implements StudentResource{
	private StudentService studentService;

	public StudentJsonResource(StudentService studentService) {
		this.studentService = studentService;
	}

	@Override
	public Response create(StudentDto studentDto) throws ServiceException {

		studentService.create(studentDto);

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.SUCCESS_RESPONSE)
				.withMessage(MessageDataManager.CLIENT_CREATED)
				.getResponseDto();

		return Response.status(Response.Status.CREATED).entity(responseDto).build();
	}

	@Override
	public Response getAllStudents() throws ServiceException {
		List<StudentDto> studentDtos =  studentService.getAll();

		return Response.status(Response.Status.OK).entity( new GenericEntity<List<StudentDto>>(studentDtos){}).build();
	}
}
