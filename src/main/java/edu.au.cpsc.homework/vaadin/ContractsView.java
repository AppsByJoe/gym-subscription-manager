/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.vaadin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.selection.SelectionEvent;
import com.vaadin.flow.router.Route;
import edu.au.cpsc.homework.entity.Client;
import edu.au.cpsc.homework.usecase.ManageClients;
import java.util.Optional;

@Route(value = "/assign_contracts", layout = MainView.class)
public class ContractsView extends VerticalLayout {
  private ManageClients manageClients;
  private final Grid<Client> grid;

  private Client selectedClient = null;

  public ContractsView(ManageClients manageClients) {
    this.manageClients = manageClients;
    grid = createGrid();
    VerticalLayout leftSideForm = new VerticalLayout();
    VerticalLayout rightSideForm = new VerticalLayout();
    HorizontalLayout rolledForm = new HorizontalLayout();
    rolledForm.add(createToolbar(), leftSideForm, rightSideForm);
    add(grid, rolledForm);
    updateGrid();

    for (Column c : grid.getColumns()) {
      c.setSortable(true);
    }
  }

  private Grid<Client> createGrid() {
    Grid<Client> grid = new Grid<>(Client.class, false);
    grid.addColumn(Client::getName).setHeader("Client Name");
    grid.addColumn(Client::getActiveContractTemplateName).setHeader("Active Contract Name");
    grid.addColumn(Client::getActiveContractStartDate).setHeader("Start Date");
    grid.addColumn(Client::getPricingPlanInfo).setHeader("Pricing Plan Information");

    grid.setSelectionMode(SelectionMode.SINGLE);
    grid.addSelectionListener(this::gridSelectionChanged);
    return grid;
  }

  private void gridSelectionChanged(SelectionEvent<Grid<Client>, Client> event) {
    Optional<Client> selected = event.getFirstSelectedItem();
    Client client = selected.orElse(null);
    if (client == null) {
      return;
    }

//    nameField.setValue(client.getName());

    selectedClient = client;
  }

  private Component createToolbar() {
    VerticalLayout verticalLayout = new VerticalLayout();

    // need button for assigning new contract
    // need button for extra credit deactivating current contract


    Button cancelButton = new Button("Cancel changes and clear current selected Client");
    cancelButton.addClickListener(event -> cancelButtonPressed());
    verticalLayout.add(cancelButton);

    return verticalLayout;
  }

  private void updateGrid() {
    grid.setItems(manageClients.getClients());
  }

  private void cancelButtonPressed() {
    // clear selected client display field
    // clear new contract field
    selectedClient = null;
  }
}
