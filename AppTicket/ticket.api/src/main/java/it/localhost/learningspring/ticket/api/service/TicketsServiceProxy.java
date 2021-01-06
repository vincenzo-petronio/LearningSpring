package it.localhost.learningspring.ticket.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import it.localhost.learningspring.ticket.api.model.Ticket;

@FeignClient("ticket-tickets-service")
public interface TicketsServiceProxy {

    @GetMapping("/tickets")
    List<Ticket> getTickets();

    @GetMapping("/tickets/{id}")
    Optional<Ticket> getTicket(@PathVariable("id") long id);

    @PostMapping("/tickets")
    Ticket saveTicket(@RequestBody Ticket ticket);

    @DeleteMapping("/tickets/{id}")
    void deleteTicket(@PathVariable long id);
}
