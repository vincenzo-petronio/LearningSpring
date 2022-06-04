package it.localhost.learningspring.ticket.user.dto;

import it.localhost.learningspring.ticket.user.model.AddressType;

public class AddressDto {

	private long id;

	private String value;

	private AddressType type;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public AddressType getType() {
		return type;
	}

	public void setType(AddressType type) {
		this.type = type;
	}
	
	
}
