package it.localhost.learningspring.ticket.api.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class TicketResDto {

    private BigInteger code;
    
    private LocalDateTime dateCreated;

    public BigInteger getCode() {
        return code;
    }

    public void setCode(BigInteger code) {
        this.code = code;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
