package api.resource.haircut;

import application.service.exception.ServiceException;
import domain.user.AccessLevel;
import middleware.authentication.NeedAuthentication;
import middleware.role.HasRole;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Path("/haircut")
public interface HaircutResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Response create(HaircutDto haircutDto) throws ServiceException;
}
