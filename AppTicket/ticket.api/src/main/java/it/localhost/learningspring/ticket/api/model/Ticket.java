package it.localhost.learningspring.ticket.api.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class Ticket {

    private Long id;

    private BigInteger code;

    private LocalDateTime created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
