package infrastructure.repository.user.client;

import domain.CouronneAfroDomainException;

public class ClientNotFoundException extends CouronneAfroDomainException {
	public ClientNotFoundException() {
		super("client non trouvé ");
	}
}
