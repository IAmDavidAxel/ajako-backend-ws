package infrastructure.repository.user.barber;

import domain.CouronneAfroDomainException;

public class BarberNotFoundException extends CouronneAfroDomainException {
	public BarberNotFoundException(String barberUsername) {
		super(" le/la coiffeur(euse)" + barberUsername+"est introuvable");
	}
}
