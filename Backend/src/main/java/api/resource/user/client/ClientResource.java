package api.resource.user.client;

import api.dto.user.client.ClientDto;
import application.service.exception.ServiceException;

public interface ClientResource {
	void create(ClientDto clientDto) throws ServiceException;
}
