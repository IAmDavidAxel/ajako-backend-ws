package api.user.student;

import api.dto.user.student.StudentDto;
import application.service.exception.ServiceException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/student")
public interface StudentResource {


	@POST
	@Path("/creer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Response create(StudentDto studentDto) throws ServiceException;

	@GET
	@Path("/tousLesEleves")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Response getAllStudents() throws ServiceException;
}
