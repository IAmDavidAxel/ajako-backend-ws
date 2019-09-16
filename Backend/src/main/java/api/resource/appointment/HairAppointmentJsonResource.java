package api.resource.appointment;

import api.dto.ResponseDto;
import api.response.ResponseDtoBuilder;
import application.service.user.client.ClientService;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.Response;

public class HairAppointmentJsonResource {

	private ClientService clientService;

	public HairAppointmentJsonResource(ClientService clientService) {

		this.clientService = clientService;
	}


	public Response makeHairAppointment(AppointmentDto appointmentDto) {

		clientService.makeHairAppointment(appointmentDto);

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withMessage(MessageDataManager.APPOINTMENT_SUCCESSFULLY_MADE)
				.withStatus(MessageDataManager.SUCCESS_RESPONSE)
				.getResponseDto();

		return Response.status(Response.Status.CREATED).entity(responseDto).build();
	}
}
