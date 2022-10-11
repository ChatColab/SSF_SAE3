package com.example.application.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Main")
@Route(value = "")
public class MainView extends VerticalLayout {

    Button helloButton = new Button("Hello");

    public MainView() {
        add(helloButton);

        helloButton.addClickListener(e -> {
            Notification.show("Hello World");
        });

        //align all center horizontally and vertically
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    }

}
