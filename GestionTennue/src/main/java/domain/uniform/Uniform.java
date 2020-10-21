package domain.uniform;

import utility.servicelocator.ServiceLocator;

public class Uniform {

	private UniformId uniformId;
	private int size;
	private float price;
	private Type type;
	private SousType sousType;


	public Uniform(UniformId uniformId,int size, float price, Type type, SousType sousType) {
		this.uniformId = uniformId;
		this.size = size;
		this.price = price;
		this.type = type;
		this.sousType = sousType;
	}

	public int getSize() {
		return size;
	}


	public float getPrice() {
		return price;
	}


	public Type getType() {
		return type;
	}



	public SousType getSousType() {
		return sousType;
	}


	public UniformId getUniformId() {
		return uniformId;
	}
}
