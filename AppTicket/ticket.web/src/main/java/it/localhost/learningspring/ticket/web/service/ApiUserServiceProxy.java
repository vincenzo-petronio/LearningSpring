package it.localhost.learningspring.ticket.web.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("ticket-user-service")
public interface ApiUserServiceProxy {

    @GetMapping("/api/v1/users")
    String getUsers();

    @PostMapping(value = "/api/v1/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    String saveUser(@RequestBody String jsonUser);

    @GetMapping("/api/v1/users/{id}")
    String getUser(@PathVariable("id") long id);
}
