package it.localhost.learningspring.ticket.web.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    private static final long serialVersionUID = 1L;

    private final Button btnGetTickets, btnGetTicket;
    private final Label txtMessage;

    public MainView() {
        H1 title = new H1("Hello Vaadin!");
        txtMessage = new Label();

        btnGetTickets = new Button("Get Tickets");
        btnGetTickets.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

            private static final long serialVersionUID = 2882299594962574915L;

            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                System.out.println("CLICK TICKETS");
                txtMessage.setText("CLICK TICKETS");
            }
        });

        btnGetTicket = new Button("Get Ticket");
        btnGetTicket.addClickListener(e -> {
            System.out.println("CLICK TICKET");
            txtMessage.setText("CLICK TICKET");
        });

        add(title, btnGetTickets, btnGetTicket, txtMessage);
    }
}
