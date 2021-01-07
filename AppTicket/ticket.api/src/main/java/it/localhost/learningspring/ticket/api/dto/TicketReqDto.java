package it.localhost.learningspring.ticket.api.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class TicketReqDto {

    private BigInteger code;

    private LocalDateTime created;

    public BigInteger getCode() {
        return code;
    }

    public void setCode(BigInteger code) {
        this.code = code;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
