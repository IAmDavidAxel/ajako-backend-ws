package application.service.haircut;

import api.resource.haircut.HaircutDto;
import domain.haircut.Haircut;

public class HaircutAssembler {

	public Haircut assemble(HaircutDto haircutDto) {

		String name = haircutDto.getName();
		float price =haircutDto.getPrice();

		return new Haircut(name,price);
	}
}

