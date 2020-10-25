package it.localhost.learningspring.ticket.api.service;

import java.util.List;
import java.util.Optional;

import it.localhost.learningspring.ticket.api.model.Ticket;

public interface TicketService {

    List<Ticket> GetListTicket();

    Optional<Ticket> GetTicket(long id);
}
