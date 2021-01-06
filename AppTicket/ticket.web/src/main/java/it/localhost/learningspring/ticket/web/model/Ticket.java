package it.localhost.learningspring.ticket.web.model;

import java.time.LocalDateTime;

public class Ticket {

    private int code;

    private LocalDateTime created;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
