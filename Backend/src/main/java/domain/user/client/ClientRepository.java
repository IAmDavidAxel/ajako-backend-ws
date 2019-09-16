package domain.user.client;

import infrastructure.repository.user.client.ClientNotFoundException;

public interface ClientRepository {
	Client findClientByUsername(String clientUsername) throws ClientNotFoundException;
}
