package application.service.haircut;

import api.resource.haircut.HaircutDto;
import domain.haircut.Haircut;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HaircutAssemblerTest {

	private static final String HAIRCUT_NAME = "luz Clarita";
	private static final float HAIRCUT_PRICE = 18;

	private HaircutAssembler haircutAssembler;
	private HaircutDto haircutDto;

	private void setUpDto(){
		haircutDto = new HaircutDto();

		haircutDto.setName(HAIRCUT_NAME);
		haircutDto.setPrice(HAIRCUT_PRICE);
	}

	@Before
	public void setUp(){
		setUpDto();
		haircutAssembler = new HaircutAssembler();
	}

	@Test
	public void whenAssemblingToDomainObject_thenAllAttributesAreEqual(){

		Haircut haircutFromAssembler = haircutAssembler.assemble(haircutDto);

		String nameFromAssembler = haircutFromAssembler.getName();
		float priceFromAssembler = haircutFromAssembler.getPrice();

		assertEquals(nameFromAssembler,HAIRCUT_NAME);
		assertEquals(priceFromAssembler,HAIRCUT_PRICE,1);
	}

}
