package api.dto.uniform;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import domain.uniform.SousType;
import domain.uniform.Type;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UniformDto {

	@JsonProperty(value = "size")
	private int size;

	@JsonProperty(value = "price")
	private float price;

	@JsonProperty(value = "type")
	private Type type;
	@JsonProperty(value = "sous_type")
	private SousType sousType;

	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getPrice() {
		return price;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public void setSousType(SousType sousType) {
		this.sousType = sousType;
	}

	public SousType getSousType() {
		return sousType;
	}
}
