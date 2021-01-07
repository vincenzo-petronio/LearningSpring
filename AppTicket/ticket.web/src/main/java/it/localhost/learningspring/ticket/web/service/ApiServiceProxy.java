package it.localhost.learningspring.ticket.web.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("ticket-apigtw-service")
public interface ApiServiceProxy {

    @GetMapping("/api/v1/tickets")
    String getTickets();

    @PostMapping(value = "/api/v1/tickets", consumes = MediaType.APPLICATION_JSON_VALUE)
    String createTicket(@RequestBody String jsonTicket);

    @GetMapping("/api/v1/tickets/{id}")
    String getTicket(@PathVariable("id") long id);

    @DeleteMapping("/api/v1/tickets/{id}")
    String deleteTicket(@PathVariable("id") long id);
}
