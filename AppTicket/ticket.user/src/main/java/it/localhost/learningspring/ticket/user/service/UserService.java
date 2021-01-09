package it.localhost.learningspring.ticket.user.service;

import java.util.List;
import java.util.Optional;

import it.localhost.learningspring.ticket.user.model.User;

public interface UserService {

    List<User> GetListUsers();

    Optional<User> GetUser(long id);

    User SaveUser(UserDTO userDTO);
}
