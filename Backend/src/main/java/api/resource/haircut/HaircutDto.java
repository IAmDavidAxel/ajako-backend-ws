package api.resource.haircut;

public class HaircutDto {
	private String name;
	private float price;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getPrice() {
		return price;
	}
}
