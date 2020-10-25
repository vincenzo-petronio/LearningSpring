package it.localhost.learningspring.ticket.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.localhost.learningspring.ticket.api.dto.TicketResDto;
import it.localhost.learningspring.ticket.api.service.TicketService;

@RestController
public class TicketController {

//    @Autowired
//    private Environment environment;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets")
    public ResponseEntity<List<TicketResDto>> GetTickets() {
        List<TicketResDto> result = ticketService.GetListTicket().stream()
                .map(t -> modelMapper.map(t, TicketResDto.class)).collect(Collectors.toUnmodifiableList());
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/tickets/{id}")
    public ResponseEntity<TicketResDto> GetTicket(@PathVariable long id) {
        Optional<TicketResDto> result = ticketService.GetTicket(id).stream()
                .map(t -> modelMapper.map(t, TicketResDto.class)).findFirst();
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result.get());
    }
}
