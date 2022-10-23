package com.example.application.views.main;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Main")
@Route(value = "")
public class MainView extends VerticalLayout {

    Button helloButton = new Button("Hello");

    public MainView() {

        Button home = new Button("Home", VaadinIcon.HOME.create());
        Button user = new Button("User", VaadinIcon.USER.create());
        Button search = new Button("Search", VaadinIcon.SEARCH.create());

        for (Button button : new Button[] { home, user, search }) {
            button.setWidth("33%");
            button.setHeightFull();
            button.getStyle().set("align-self", "center");
        }

        FlexLayout header = new FlexLayout(home, user, search);
        header.setJustifyContentMode(JustifyContentMode.BETWEEN);
        header.setWidthFull();
        header.setHeight("70px");

        add(header);

        add(helloButton);

        helloButton.addClickShortcut(Key.ENTER);
        helloButton.addClickListener(e -> {
            Notification.show("Hello World");
        });
    }

}
