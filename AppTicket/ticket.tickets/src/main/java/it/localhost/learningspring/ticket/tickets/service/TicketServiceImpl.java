package it.localhost.learningspring.ticket.tickets.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import it.localhost.learningspring.ticket.tickets.dto.TicketDto;
import it.localhost.learningspring.ticket.tickets.model.Ticket;
import it.localhost.learningspring.ticket.tickets.model.TicketRepository;

public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<TicketDto> GetListTicket() {
		return ((List<Ticket>) ticketRepository.findAll()).stream().map(u -> modelMapper.map(u, TicketDto.class))
				.collect(Collectors.toUnmodifiableList());
	}

	@Override
	public Optional<TicketDto> GetTicket(long id) {
		return ticketRepository.findById(id).map(u -> modelMapper.map(u, TicketDto.class));
	}

	@Override
	public Ticket SaveOrUpdateTicket(TicketDto ticketDto) {
		Ticket ticket = modelMapper.map(ticketDto, Ticket.class);
		return ticketRepository.save(ticket);
	}

	@Override
	public void DeleteTicket(long id) {
		ticketRepository.deleteById(id);
	}
}
