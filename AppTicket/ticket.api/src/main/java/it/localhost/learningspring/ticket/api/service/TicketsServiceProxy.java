package it.localhost.learningspring.ticket.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.localhost.learningspring.ticket.api.model.Ticket;

@FeignClient("ticket-tickets-service")
public interface TicketsServiceProxy {

    @GetMapping("/tickets")
    List<Ticket> getTickets();

    @GetMapping("/tickets/{id}")
    Optional<Ticket> getTicket(@PathVariable("id") long id);
}
