package it.localhost.learningspring.ticket.web.view;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;

import com.netflix.discovery.EurekaClient;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    @Autowired
    private EurekaClient eurekaClient;

    private static final long serialVersionUID = 1L;

    private final Button btnGetTickets, btnGetTicket;
    private final Label txtMessage;

    public MainView() {
        H1 title = new H1("Hello Vaadin!");
        txtMessage = new Label();

        btnGetTickets = new Button("Get Tickets - HttpClient");
        btnGetTickets.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

            private static final long serialVersionUID = 2882299594962574915L;

            @Override
            public void onComponentEvent(ClickEvent<Button> event) {

                var instances = eurekaClient.getApplication("ticket-apigtw-service").getInstances();
                var instanceZero = instances.get(0);
                URI apiUri = URI.create(String.format("http://%s:%s/api/v1/tickets/", instanceZero.getHostName(),
                        instanceZero.getPort()));

                try {
                    txtMessage.setText(getApiAsync(apiUri).get());
                } catch (InterruptedException ie) {
                    txtMessage.setText(ie.getMessage());
                } catch (ExecutionException ee) {
                    txtMessage.setText(ee.getMessage());
                }
            }
        });

        btnGetTicket = new Button("Get Ticket - Feign");
        btnGetTicket.addClickListener(e -> {
            System.out.println("CLICK TICKET");
            txtMessage.setText("CLICK TICKET");
        });

        add(title, btnGetTickets, btnGetTicket, txtMessage);

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
