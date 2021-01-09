package it.localhost.learningspring.ticket.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.localhost.learningspring.ticket.user.model.User;
import it.localhost.learningspring.ticket.user.service.UserDTO;
import it.localhost.learningspring.ticket.user.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> GetUsers() {
        return userService.GetListUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> GetUser(@PathVariable long id) {
        return userService.GetUser(id);
    }

    @PostMapping("/users")
    public User SaveUser(@RequestBody UserDTO userDTO) {
        return userService.SaveUser(userDTO);
    }
}
