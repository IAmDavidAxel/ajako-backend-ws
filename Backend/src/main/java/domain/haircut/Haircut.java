package domain.haircut;

public class Haircut {


	private String name;
	private float price;

	public Haircut(String name, float price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}



	public float getPrice() {
		return price;
	}


}
