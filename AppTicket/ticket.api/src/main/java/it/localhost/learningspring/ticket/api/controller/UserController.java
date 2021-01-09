package it.localhost.learningspring.ticket.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.localhost.learningspring.ticket.api.dto.UserReqDTO;
import it.localhost.learningspring.ticket.api.dto.UserResDTO;
import it.localhost.learningspring.ticket.api.service.UserServiceProxy;

@RestController
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserServiceProxy userServiceProxy;

    @GetMapping("/users")
    public ResponseEntity<List<UserResDTO>> GetUsers() {
        List<UserResDTO> result = userServiceProxy.getUsers().stream().map(t -> modelMapper.map(t, UserResDTO.class))
                .collect(Collectors.toUnmodifiableList());
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResDTO> SaveUser(@RequestBody UserReqDTO user) {
        UserResDTO userSaved = userServiceProxy.saveUser(user);
//        UserResDTO userResult = modelMapper.map(userSaved, UserResDTO.class);
        return ResponseEntity.ok(userSaved);
    }
}
