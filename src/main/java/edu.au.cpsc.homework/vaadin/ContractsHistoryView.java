/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.vaadin;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import edu.au.cpsc.homework.entity.Client;
import edu.au.cpsc.homework.entity.Contract;
import edu.au.cpsc.homework.usecase.ManageClients;

/**
 * Displayed in right frame of Gym Manager browser app.  Attempted Extra Credit.
 */
@Route(value = "/view_contracts_history", layout = MainView.class)
public class ContractsHistoryView extends HorizontalLayout {

  private final Grid<Contract> grid;
  private final ComboBox<Client> selectedClientField = new ComboBox<>("Select Client");

  /**
   * Constructor which instantiates and organizes the elements of the /view_contracts_history url.
   *
   * @param manageClients The use case object used by this view.
   */
  public ContractsHistoryView(ManageClients manageClients) {
    selectedClientField.setItems(manageClients.getClients());
    selectedClientField.setItemLabelGenerator(Client::getName);
    selectedClientField.addValueChangeListener(event -> updateGrid());
    grid = createGrid();
    add(selectedClientField, grid);

    for (Column<?> c : grid.getColumns()) {
      c.setSortable(true);
    }
  }

  private Grid<Contract> createGrid() {
    Grid<Contract> grid = new Grid<>(Contract.class, false);
    grid.addColumn(Contract::getName).setHeader("Contract Name");
    grid.addColumn(Contract::getIsActive).setHeader("Activity Status");
    grid.addColumn(Contract::getStartDate).setHeader("Start Date");
    grid.addColumn(Contract::getPricingPlan).setHeader("Pricing Plan Information");

    grid.setSelectionMode(SelectionMode.SINGLE);
    return grid;
  }

  private void updateGrid() {
    grid.setItems(selectedClientField.getValue().getContracts());
  }
}
