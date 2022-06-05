package it.localhost.learningspring.ticket.tickets.dto;

import java.util.Date;
import java.util.UUID;

public class TicketDto {

	private long id;

	private UUID code;

	private Date created;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UUID getCode() {
		return code;
	}

	public void setCode(UUID code) {
		this.code = code;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	
}
