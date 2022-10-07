/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.vaadin;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("")
@Theme(variant = Lumo.DARK)
public class MainView extends AppLayout implements AppShellConfigurator {
  public MainView() {
    DrawerToggle drawerToggle = new DrawerToggle();
    addToNavbar(drawerToggle, new H3("Gym Manager"));
    addToDrawer(drawerTabs());
  }

  private Tabs drawerTabs() {
    Tabs tabs = new Tabs();

    Icon clientsIcon = VaadinIcon.USERS.create();
    clientsIcon.getStyle()
        .set("box-sizing", "border-box")
        .set("margin-inline-end", "var(--lumo-space-m)")
        .set("margin-inline-start", "var(--lumo-space-xs)")
        .set("padding", "var(--lumo-space-xs)");
    RouterLink clientsLink = new RouterLink(ClientsView.class);
    clientsLink.add(clientsIcon, new Span("Manage Clients"));
    tabs.add(new Tab(clientsLink));

    Icon contractsIcon = VaadinIcon.NEWSPAPER.create();
    contractsIcon.getStyle()
        .set("box-sizing", "border-box")
        .set("margin-inline-end", "var(--lumo-space-m)")
        .set("margin-inline-start", "var(--lumo-space-xs)")
        .set("padding", "var(--lumo-space-xs)");
    RouterLink contractsLink = new RouterLink(ContractsView.class);
    contractsLink.add(contractsIcon, new Span(" Assign Contracts"));
    tabs.add(new Tab(contractsLink));

    tabs.setOrientation(Tabs.Orientation.VERTICAL);
    return tabs;
  }
}