/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.vaadin;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.selection.SelectionEvent;
import com.vaadin.flow.router.Route;
import edu.au.cpsc.homework.entity.Client;
import edu.au.cpsc.homework.usecase.ManageClients;
import java.util.Optional;

@Route(value = "/manage_clients", layout = MainView.class)
public class ClientsView extends VerticalLayout {
  private ManageClients manageClients;
  private final Grid<Client> grid;
  private Client selectedClient = null;
  TextField nameField = new TextField("Name");
  TextField emailField = new TextField("Email");
  DatePicker dobField = new DatePicker("Date of Birth");
  TextField streetField = new TextField("Street");
  TextField cityField = new TextField("City");
  TextField stateField = new TextField("State");
  IntegerField zipField = new IntegerField("Zip");

  public ClientsView(ManageClients manageClients) {
    this.manageClients = manageClients;
    grid = createGrid();
    VerticalLayout leftSideForm = new VerticalLayout();
    VerticalLayout middleSideForm = new VerticalLayout();
    VerticalLayout rightSideForm = new VerticalLayout();
    leftSideForm.add(nameField, emailField, dobField);
    middleSideForm.add(cityField, stateField, zipField);
    rightSideForm.add(streetField);
    HorizontalLayout rolledForm = new HorizontalLayout();
    rolledForm.add(createToolbar(), leftSideForm, middleSideForm, rightSideForm);
    add(grid, rolledForm);
    updateGrid();

    for (Column c : grid.getColumns()) {
      c.setSortable(true);
    }
  }

  private Grid<Client> createGrid() {
    Grid<Client> grid = new Grid<>(Client.class, false);
    grid.addColumn(Client::getName).setHeader("Name");
    grid.addColumn(Client::getEmail).setHeader("Email");
    grid.addColumn(Client::getDateOfBirth).setHeader("DOB");
    grid.addColumn(Client::getStreet).setHeader("Street");
    grid.addColumn(Client::getCity).setHeader("City");
    grid.addColumn(Client::getState).setHeader("State");
    grid.addColumn(Client::getZip).setHeader("Zip");
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
    nameField.setValue(client.getName());
    emailField.setValue(client.getEmail());
    dobField.setValue(client.getDateOfBirth());
    streetField.setValue(client.getStreet());
    cityField.setValue(client.getCity());
    stateField.setValue(client.getState());
    zipField.setValue(client.getZip());
    selectedClient = client;
  }

  private void updateGrid() {
    grid.setItems(manageClients.getClients());
  }

  private Component createToolbar() {
    VerticalLayout verticalLayout = new VerticalLayout();
    Button saveNewClientButton = new Button("Save Form Data as a New Client");
    saveNewClientButton.addClickListener(event -> saveNewClientButtonPressed());
    verticalLayout.add(saveNewClientButton);
    Button updateExistingClientButton = new Button("Save Changes to Existing Client");
    updateExistingClientButton.addClickListener(event -> updateExistingClientButtonPressed());
    verticalLayout.add(updateExistingClientButton);
    Button cancelButton = new Button("Cancel Changes and Clear Form");
    cancelButton.addClickListener(event -> cancelButtonPressed());
    verticalLayout.add(cancelButton);
    
    return verticalLayout;
  }

  private void cancelButtonPressed() {
    nameField.clear();
    emailField.clear();
    dobField.clear();
    streetField.clear();
    cityField.clear();
    stateField.clear();
    zipField.clear();
    selectedClient = null;
  }

  private void updateExistingClientButtonPressed() {
    if (selectedClient != null) {
      saveFormData();
      Notification.show("Changes saved.");

      updateGrid();
    } else {
      Notification.show("Update failed.  No such Client exists.");
    }
  }

  private void saveNewClientButtonPressed() {
    if (selectedClient != null) {
      Notification.show("Save failed. Client already exists.");
    } else if (nameField.getValue().isBlank()
        || streetField.getValue().isBlank()
        || cityField.getValue().isBlank()
        || stateField.getValue().isBlank()
        || zipField.getValue() == 0) {
      Notification.show("Save failed. All fields except email are required.");
    } else {
      selectedClient = new Client();
      saveFormData();
      Notification.show("New Client successfully saved.");

      updateGrid();
    }
  }

  private void saveFormData() {
    selectedClient.setName(nameField.getValue());
    selectedClient.setEmail(emailField.getValue());
    selectedClient.setDateOfBirth(dobField.getValue());
    selectedClient.setStreet(streetField.getValue());
    selectedClient.setCity(cityField.getValue());
    selectedClient.setState(stateField.getValue());
    selectedClient.setZip(zipField.getValue());
    manageClients.saveClient(selectedClient);
    cancelButtonPressed();
  }
}
