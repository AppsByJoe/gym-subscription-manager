/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.vaadin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.selection.SelectionEvent;
import com.vaadin.flow.router.Route;
import edu.au.cpsc.homework.entity.Client;
import edu.au.cpsc.homework.entity.ContractTemplate;
import edu.au.cpsc.homework.usecase.ManageClients;
import java.util.Optional;

/**
 * Displayed in right frame of Gym Manager browser app.  Fulfills the Assign Contracts use case.
 */
@Route(value = "/assign_contracts", layout = MainView.class)
public class ContractsView extends VerticalLayout {

  private final ManageClients manageClients;
  private final Grid<Client> grid;
  private final TextField selectedUserField = new TextField("Selected Client Name");
  private final ComboBox<ContractTemplate> selectedContractField =
      new ComboBox<>("Select Contract Type");
  private Client selectedClient = null;

  /**
   * Constructor which instantiates and organizes the elements of the /assign_contracts url.
   *
   * @param manageClients The use case object used by this view.
   */
  public ContractsView(ManageClients manageClients) {
    this.manageClients = manageClients;
    selectedUserField.setReadOnly(true);
    grid = createGrid();
    HorizontalLayout rightSideForm = new HorizontalLayout();
    rightSideForm.add(selectedUserField, selectedContractField);
    HorizontalLayout rolledForm = new HorizontalLayout();
    rolledForm.add(createToolbar(), rightSideForm);
    add(grid, rolledForm);
    updateGrid();

    for (Column<?> c : grid.getColumns()) {
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
    selectedClient = client;
    selectedUserField.setValue(client.getName());
    selectedContractField.setItems(manageClients.getEligibleTemplates(client));
    selectedContractField.setItemLabelGenerator(ContractTemplate::getName);
  }

  private Component createToolbar() {
    VerticalLayout verticalLayout = new VerticalLayout();

    Button assignNewContractButton = new Button("Assign Selected Contract to Client");
    assignNewContractButton.addClickListener(event -> assignNewContractButtonPressed());
    verticalLayout.add(assignNewContractButton);

    // need button for extra credit deactivating current contract

    Button cancelButton = new Button("Cancel Changes and Deselect Client");
    cancelButton.addClickListener(event -> cancelButtonPressed());
    verticalLayout.add(cancelButton);

    return verticalLayout;
  }

  private void assignNewContractButtonPressed() {
    if (manageClients.getEligibleTemplates(selectedClient).contains(selectedContractField
        .getValue())) {
      manageClients.addEligibleContractToClient(selectedClient, selectedContractField.getValue());
      manageClients.saveClient(selectedClient);
      cancelButtonPressed();
      updateGrid();
      Notification.show("Assignment successful.");
    } else {
      Notification.show("Assignment failed.  Client is not eligible for selected contract.");
    }
  }

  private void updateGrid() {
    grid.setItems(manageClients.getClients());
  }

  private void cancelButtonPressed() {
    selectedUserField.clear();
    selectedContractField.clear();
    selectedClient = null;
  }
}
