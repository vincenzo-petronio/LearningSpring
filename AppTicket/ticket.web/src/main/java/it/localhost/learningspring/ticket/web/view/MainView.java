package it.localhost.learningspring.ticket.web.view;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;

import com.netflix.discovery.EurekaClient;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.Route;

import it.localhost.learningspring.ticket.web.service.ApiServiceProxy;

@Route
public class MainView extends VerticalLayout {

    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private ApiServiceProxy apiServiceProxy;

    private static final long serialVersionUID = 1L;

    private final Button btnGetTickets, btnGetTicket, btnNewTicket, btnDelTicket;
    private final Label txtMessage;
    private final IntegerField txtNumber;

    public MainView() {
        H1 title = new H1("Hello Vaadin!");
        txtMessage = new Label();

        txtNumber = new IntegerField("Ticket to GET or DEL");

        btnGetTickets = new Button("Get Tickets - HttpClient");
        btnGetTickets.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

            private static final long serialVersionUID = 2882299594962574915L;

            @Override
            public void onComponentEvent(ClickEvent<Button> event) {

                // recupero le istanze del servizio, poi ne chiamo una in modo random.
                var instances = eurekaClient.getApplication("ticket-apigtw-service").getInstances();
                int instanceIndex = instances.size() > 1 ? new Random().nextInt(instances.size() - 1) : 0;
                var instance = instances.get(instanceIndex);
                URI apiUri = URI.create(
                        String.format("http://%s:%s/api/v1/tickets/", instance.getHostName(), instance.getPort()));

                try {
                    txtMessage.setText("" + instanceIndex + ": " + getApiAsync(apiUri).get());
                } catch (InterruptedException ie) {
                    txtMessage.setText(ie.getMessage());
                } catch (ExecutionException ee) {
                    txtMessage.setText(ee.getMessage());
                }
            }
        });

        btnGetTicket = new Button("Get Ticket - Feign");
        btnGetTicket.addClickListener(e -> {
            txtMessage.setText(apiServiceProxy.getTicket(txtNumber.getValue()));
        });

        btnNewTicket = new Button("Create random Ticket");
        btnNewTicket.addClickListener(t -> {
            LocalDateTime dateTimeNow = LocalDateTime.now();
            int randomCode = Math.abs((new Random()).nextInt());
            String jsonTicket = "{\"code\": " + randomCode + ",\"created\": \"" + dateTimeNow + "\"}";
            apiServiceProxy.createTicket(jsonTicket);
        });

        btnDelTicket = new Button("Delete Ticket");
        btnDelTicket.addClickListener(t -> {
            apiServiceProxy.deleteTicket(txtNumber.getValue());
        });

        HorizontalLayout hl = new HorizontalLayout();
        hl.add(btnGetTickets, btnGetTicket, btnNewTicket, btnDelTicket);

        add(title, txtNumber, hl, txtMessage);
    }

    // Versione sync
    private String getApi(URI uri) {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpReq = HttpRequest.newBuilder().uri(uri).build();
            HttpResponse<String> httpRes;
            httpRes = httpClient.send(httpReq, BodyHandlers.ofString());
            return httpRes.body();
        } catch (IOException ioe) {
            return ioe.getMessage();
        } catch (InterruptedException ie) {
            return ie.getMessage();
        }
    }

    // Versione async
    private CompletableFuture<String> getApiAsync(URI uri) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpReq = HttpRequest.newBuilder().uri(uri).build();
        return httpClient.sendAsync(httpReq, BodyHandlers.ofString()).thenApply(HttpResponse::body);
    }

}
