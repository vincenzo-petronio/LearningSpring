package it.localhost.learningspring.ticket.api;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.localhost.learningspring.ticket.api.service.TicketService;
import it.localhost.learningspring.ticket.api.service.TicketServiceImpl;

/**
 * Configuration class.
 * Di default tutti i bean sono istanze singleton.
 *
 */
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
