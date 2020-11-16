package it.localhost.learningspring.ticket.tickets.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import it.localhost.learningspring.ticket.tickets.model.Ticket;
import it.localhost.learningspring.ticket.tickets.model.TicketRepository;

public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> GetListTicket() {
        return ticketRepository.findAll();
    }

    @Override
    public Optional<Ticket> GetTicket(long id) {
        return ticketRepository.findById(id);
    }

}
