package api.resource.user.barber;

import api.dto.ResponseDto;
import api.response.ResponseDtoBuilder;
import application.service.exception.ServiceException;
import application.service.user.barber.BarberService;
import application.service.user.manager.ManagerService;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.Response;

public class BarberJsonResource {
	private BarberService barberService;
	private ManagerService managerService;

	public BarberJsonResource(BarberService barberService, ManagerService managerService) {

		this.barberService = barberService;
		this.managerService = managerService;
	}

	public Response createBarber(BarberDto barberDto)  throws ServiceException {

		barberService.create(barberDto);

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.SUCCESS_RESPONSE)
				.withMessage(MessageDataManager.BARBER_CREATED)
				.getResponseDto();

		return Response.status(Response.Status.CREATED).entity(responseDto).build();
	}

	public Response createDriverByManager(BarberDto barberDto) throws ServiceException {


		managerService.create(barberDto);

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withMessage(MessageDataManager.SUCCESS_RESPONSE)
				.withStatus(MessageDataManager.BARBER_CREATED)
				.getResponseDto();

		return Response.status(Response.Status.CREATED).entity(responseDto).build();
	}
}
