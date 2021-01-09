package it.localhost.learningspring.ticket.web.view;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import it.localhost.learningspring.ticket.web.service.ApiServiceProxy;

@Route
public class UserView extends VerticalLayout {

    private static final long serialVersionUID = 1L;
    private final Label txtResult = new Label();

    @Autowired
    private ApiServiceProxy userServiceProxy;

    public UserView() {
        add(createMenu());
        add(createForm());
        add(createDivResult());
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
            ObjectMapper objMapper = new ObjectMapper();
            User user = new User();
            user.setName(tfName.getValue());
            user.setSurname(tfSurname.getValue());
            user.setBirthday(dpBirthday.getValue().toString());
            String jsonUser;
            try {
                jsonUser = objMapper.writeValueAsString(user);
                userServiceProxy.saveUser(jsonUser);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
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
        VerticalLayout vl = new VerticalLayout();
        Button btnGetUsers = new Button("Get Users");
        btnGetUsers.addClickListener(event -> {
            txtResult.setText(userServiceProxy.getUsers());
        });
        vl.add(btnGetUsers, txtResult);
        box.add(vl);
        return box;
    }

    class User {
        private String name, surname, birthday;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }
    }
}
