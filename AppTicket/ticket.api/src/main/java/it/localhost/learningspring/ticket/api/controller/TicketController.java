package it.localhost.learningspring.ticket.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.localhost.learningspring.ticket.api.dto.TicketReqDto;
import it.localhost.learningspring.ticket.api.dto.TicketResDto;
import it.localhost.learningspring.ticket.api.model.Ticket;
import it.localhost.learningspring.ticket.api.service.TicketsServiceProxy;

@RestController
public class TicketController {

    private static final Logger LOG = LoggerFactory.getLogger(TicketController.class);
//    @Autowired
//    private Environment environment;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TicketsServiceProxy ticketsServiceProxy;

    @GetMapping("/tickets")
    public ResponseEntity<List<TicketResDto>> GetTickets() {
        List<TicketResDto> result = ticketsServiceProxy.getTickets().stream()
                .map(t -> modelMapper.map(t, TicketResDto.class)).collect(Collectors.toUnmodifiableList());
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/tickets/{id}")
    public ResponseEntity<TicketResDto> GetTicket(@PathVariable long id) {
        Optional<TicketResDto> result = ticketsServiceProxy.getTicket(id).stream()
                .map(t -> modelMapper.map(t, TicketResDto.class)).findFirst();
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result.get());
    }

    @PostMapping(value = "/tickets", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> SaveTicket(@RequestBody TicketReqDto ticket) {
        LOG.debug(ticket.getCode() + " - " + ticket.getCreated().toString());
        Ticket t = modelMapper.map(ticket, Ticket.class);
        Ticket result = ticketsServiceProxy.saveTicket(t);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/tickets/{id}")
    public ResponseEntity<Long> deleteTicket(@PathVariable long id) {
        ticketsServiceProxy.deleteTicket(id);
        return ResponseEntity.ok(id);
    }
}
