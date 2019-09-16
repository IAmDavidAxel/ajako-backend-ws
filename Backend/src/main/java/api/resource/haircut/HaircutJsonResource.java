package api.resource.haircut;

import api.dto.ResponseDto;
import api.response.ResponseDtoBuilder;
import application.service.exception.ServiceException;
import application.service.user.barber.BarberService;
import application.service.user.manager.ManagerService;
import domain.user.AccessLevel;
import middleware.authentication.NeedAuthentication;
import middleware.role.HasRole;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.Response;

public class HaircutJsonResource implements  HaircutResource{


	private  BarberService barberService;
	private  ManagerService managerService;

	public HaircutJsonResource(BarberService barberService, ManagerService managerService) {

		this.barberService = barberService;
		this.managerService = managerService;
	}


	@Override
	@NeedAuthentication
	@HasRole(role = AccessLevel.MANAGER)
	public Response create(HaircutDto haircutDto) throws ServiceException {

		managerService.create(haircutDto);

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.SUCCESS_RESPONSE)
				.withMessage(MessageDataManager.HAIRCUT_CREATED)
				.getResponseDto();

		return Response.status(Response.Status.CREATED).entity(responseDto).build();
	}
}
