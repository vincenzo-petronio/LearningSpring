package it.localhost.learningspring.ticket.api;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.localhost.learningspring.ticket.api.service.TicketService;
import it.localhost.learningspring.ticket.api.service.TicketServiceImpl;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public TicketService ticketService() {
        return new TicketServiceImpl();
    }
}
