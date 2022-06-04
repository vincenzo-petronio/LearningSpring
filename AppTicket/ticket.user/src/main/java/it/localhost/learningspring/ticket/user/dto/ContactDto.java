package it.localhost.learningspring.ticket.user.dto;

import it.localhost.learningspring.ticket.user.model.ContactType;

public class ContactDto {
	
	private long id;
	
	private String value;
	
	private ContactType type;

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

	public ContactType getType() {
		return type;
	}

	public void setType(ContactType type) {
		this.type = type;
	}

}
