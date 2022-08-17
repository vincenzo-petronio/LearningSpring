package it.localhost.learningspring.ticket.tickets.service;

import java.util.List;
import java.util.Optional;

import it.localhost.learningspring.ticket.tickets.dto.TicketDto;
import it.localhost.learningspring.ticket.tickets.model.Ticket;

public interface TicketService {

    List<TicketDto> GetListTicket();

    Optional<TicketDto> GetTicket(long id);

    Ticket SaveOrUpdateTicket(TicketDto ticket);

    void DeleteTicket(long id);
}
