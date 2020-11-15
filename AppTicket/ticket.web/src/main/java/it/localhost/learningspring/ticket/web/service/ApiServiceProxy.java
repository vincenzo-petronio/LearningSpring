package it.localhost.learningspring.ticket.web.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ticket-apigtw-service")
public interface ApiServiceProxy {

    @GetMapping("/api/v1/tickets")
    String getTickets();
    
    @GetMapping("/api/v1/tickets/{id}")
    String getTicket(@PathVariable("id") long id);
}
