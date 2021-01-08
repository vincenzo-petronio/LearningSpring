package it.localhost.learningspring.ticket.web.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import it.localhost.learningspring.ticket.web.service.ApiUserServiceProxy;

@Route
public class UserView extends VerticalLayout {

    private static final long serialVersionUID = 1L;
    private final Label txtResult;

    @Autowired
    private ApiUserServiceProxy userServiceProxy;

    public UserView() {
        add(createMenu());
        add(createForm());
        add(createDivResult());
        
        txtResult = new Label();
    }

    private Div createMenu() {
        Div menu = new Div();
        menu.add(new RouterLink("Home", MainView.class));
        return menu;
    }

    private FormLayout createForm() {
        FormLayout form = new FormLayout();

        TextField tfName = new TextField();
        tfName.setLabel("First name");

        TextField tfSurname = new TextField();
        tfSurname.setLabel("Last name");

        DatePicker dpBirthday = new DatePicker();
        dpBirthday.setLabel("Birthday");
        dpBirthday.setClearButtonVisible(true);

        form.add(tfName, tfSurname, dpBirthday);

        NativeButton save = new NativeButton("Save");
        save.addClickListener(event -> {
            String jsonUser = "{\"name\": " + tfName.getValue() + ",\"surname\": \"" + tfSurname.getValue()
                    + ",\"birthday\": " + dpBirthday.getValue().toString() + "\"}";
            userServiceProxy.saveUser(jsonUser);
        });
        NativeButton reset = new NativeButton("Reset");
        reset.addClickListener(event -> {
            tfName.clear();
            tfSurname.clear();
            dpBirthday.clear();
        });
        HorizontalLayout actions = new HorizontalLayout();
        actions.add(save, reset);
        save.getStyle().set("marginRight", "10px");

        form.add(actions);
        
        return form;
    }
    
    private Div createDivResult() {
        Div box = new Div();
        Button btnGetUsers = new Button("Get Users");
        btnGetUsers.addClickListener(event -> {
            txtResult.setText(userServiceProxy.getUsers());
        });
        
        box.add(btnGetUsers, txtResult);
        return box;
    }
}
