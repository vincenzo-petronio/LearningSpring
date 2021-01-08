package it.localhost.learningspring.ticket.api.dto;

import java.util.Date;

public class UserReqDTO {

    private String name;

    private String surname;

    private Date birhday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirhday() {
        return birhday;
    }

    public void setBirhday(Date birhday) {
        this.birhday = birhday;
    }

}
