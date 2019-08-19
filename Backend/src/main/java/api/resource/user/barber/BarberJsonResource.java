package api.resource.user.barber;

import api.dto.ResponseDto;
import api.response.ResponseDtoBuilder;
import application.service.exception.ServiceException;
import application.service.user.barber.BarberService;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.Response;

public class BarberJsonResource {
	private BarberService barberService;

	public BarberJsonResource(BarberService barberService) {

		this.barberService = barberService;
	}

	public Response createBarber(BarberDto barberDto)  throws ServiceException {

		barberService.create(barberDto);

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.SUCCESS_RESPONSE)
				.withMessage(MessageDataManager.BARBER_CREATED)
				.getResponseDto();

		return Response.status(Response.Status.CREATED).entity(responseDto).build();
	}
}
