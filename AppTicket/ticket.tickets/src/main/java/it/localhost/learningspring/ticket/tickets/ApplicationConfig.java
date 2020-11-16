package it.localhost.learningspring.ticket.tickets;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.localhost.learningspring.ticket.tickets.service.TicketService;
import it.localhost.learningspring.ticket.tickets.service.TicketServiceImpl;

@Configuration
public class ApplicationConfig {

    @Bean
    public TicketService ticketService() {
        return new TicketServiceImpl();
    }
}
