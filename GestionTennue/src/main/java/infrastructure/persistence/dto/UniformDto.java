package infrastructure.persistence.dto;

import domain.uniform.SousType;
import domain.uniform.Type;

public class UniformDto {
	private String id;
	private int size;
	private float price;
	private Type type;
	private SousType sousType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public SousType getSousType() {
		return sousType;
	}

	public void setSousType(SousType sousType) {
		this.sousType = sousType;
	}
}
