package it.localhost.learningspring.ticket.user.service;

import java.util.Date;

public class UserDTO {

    String name;

    String surname;

    Date birthday;

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    Date getBirthday() {
        return birthday;
    }

}
