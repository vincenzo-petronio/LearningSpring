package it.localhost.learningspring.ticket.api.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ticket {

    @Id
    private Long id; // primary key

    @Column(name = "code")
    private BigInteger code;

    @Column(name = "created")
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

    public LocalDateTime getCreatedDateTime() {
        return created;
    }

    public void setCreatedDateTime(LocalDateTime created) {
        this.created = created;
    }
}
