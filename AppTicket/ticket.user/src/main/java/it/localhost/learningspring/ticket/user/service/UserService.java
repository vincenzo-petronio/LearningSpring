package it.localhost.learningspring.ticket.user.service;

import java.util.List;
import java.util.Optional;

import it.localhost.learningspring.ticket.user.dto.UserDto;
import it.localhost.learningspring.ticket.user.model.User;

public interface UserService {

    List<UserDto> GetListUsers();

    Optional<UserDto> GetUser(long id);

    User SaveUser(UserDto userDto);
}
