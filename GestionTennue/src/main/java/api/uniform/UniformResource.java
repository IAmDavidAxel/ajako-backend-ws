package api.uniform;

import api.dto.uniform.UniformDto;
import application.service.exception.ServiceException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.beans.ConstructorProperties;
import java.util.List;

@Path("/uniform")
public interface UniformResource {

	@POST
	@Path("/ajouter")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Response create(UniformDto uniformDto) throws ServiceException;

	@GET
	@Path("/tousLesUniforms")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Response getAllUniforms() throws ServiceException;
}
