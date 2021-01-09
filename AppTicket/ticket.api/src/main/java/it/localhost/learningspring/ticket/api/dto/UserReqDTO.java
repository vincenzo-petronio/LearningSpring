package it.localhost.learningspring.ticket.api.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserReqDTO {

    private String name;

    private String surname;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
