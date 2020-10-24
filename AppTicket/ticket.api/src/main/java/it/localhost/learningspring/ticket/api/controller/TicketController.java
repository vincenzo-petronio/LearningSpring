package it.localhost.learningspring.ticket.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.localhost.learningspring.ticket.api.model.Ticket;
import it.localhost.learningspring.ticket.api.model.TicketRepository;

@RestController
public class TicketController {

//    @Autowired
//    private Environment environment;

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping("api/v1/ticket")
    public List<Ticket> GetTickets() {
        return ticketRepository.findAll();
    }

    @GetMapping("api/v1/ticket/{id}")
    public Optional<Ticket> GetTicket(@PathVariable long id) {
        return ticketRepository.findById(id);
    }
}
