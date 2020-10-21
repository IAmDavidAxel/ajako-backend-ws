package api.uniform;

import api.dto.ResponseDto;
import api.dto.uniform.UniformDto;
import api.response.ResponseDtoBuilder;
import application.service.exception.ServiceException;
import application.service.uniform.UniformService;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;

public class UniformJsonResource implements UniformResource {
	private UniformService uniformService;

	public UniformJsonResource(UniformService uniformService) {

		this.uniformService = uniformService;
	}

	@Override
	public Response create(UniformDto uniformDto) throws ServiceException {

		uniformService.create(uniformDto);

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.SUCCESS_RESPONSE)
				.withMessage(MessageDataManager.CLIENT_CREATED)
				.getResponseDto();

		return Response.status(Response.Status.CREATED).entity(responseDto).build();
	}

	@Override
	public Response getAllUniforms() throws ServiceException {

		List<UniformDto> uniformDtos = uniformService.getAll();


		return Response.status(Response.Status.OK)
				.entity(new GenericEntity<List<UniformDto>>(uniformDtos){}).build();
	}

}
