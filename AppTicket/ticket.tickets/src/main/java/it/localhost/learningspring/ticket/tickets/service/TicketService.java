package it.localhost.learningspring.ticket.tickets.service;

import java.util.List;
import java.util.Optional;

import it.localhost.learningspring.ticket.tickets.model.Ticket;

public interface TicketService {

    List<Ticket> GetListTicket();

    Optional<Ticket> GetTicket(long id);

    Ticket SaveOrUpdateTicket(Ticket ticket);

    void DeleteTicket(long id);
}
