package it.localhost.learningspring.ticket.api.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import it.localhost.learningspring.ticket.api.dto.UserReqDTO;
import it.localhost.learningspring.ticket.api.dto.UserResDTO;

@FeignClient("ticket-user-service")
public interface UserServiceProxy {

    @GetMapping("/users")
    List<UserResDTO> getUsers();

    @PostMapping("/users")
    UserResDTO saveUser(@RequestBody UserReqDTO user);
}
