package it.localhost.learningspring.ticket.tickets.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.localhost.learningspring.ticket.tickets.model.Ticket;
import it.localhost.learningspring.ticket.tickets.service.TicketService;

@RestController
public class TicketsController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets")
    public List<Ticket> GetTickets() {
        return ticketService.GetListTicket();
    }

    @GetMapping("/tickets/{id}")
    public Optional<Ticket> GetTicket(@PathVariable long id) {
        return ticketService.GetTicket(id);
    }
    
    @PostMapping("/tickets")
    public Ticket SaveTicket(@RequestBody Ticket ticket) {
        return ticketService.SaveOrUpdateTicket(ticket);
    }
    
    @DeleteMapping("/tickets/{id}")
    public void DeleteTicket(@PathVariable long id) {
        ticketService.DeleteTicket(id);
    }
}
