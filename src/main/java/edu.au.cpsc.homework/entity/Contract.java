/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.entity;


import java.time.LocalDate;
import javax.validation.constraints.NotNull;

/**
 * This class defines objects which represent a client's contract with the gym.
 */
@javax.persistence.Entity
public class Contract extends Entity {

  @NotNull
  private LocalDate startDate;
  @NotNull
  private boolean isActive;
  @NotNull
  private ContractTemplate contractTemplate;

  /**
   * Constructor for contract object.  Takes as input a contractTemplate enum type, then creates a
   * new contract object while instantiating the current local date and isActive active status. For
   * use by Client objects in their contracts list field.
   *
   * @param contractTemplate ContractTemplate enumerated type noting the type of contract to create
   */
  public Contract(ContractTemplate contractTemplate) {
    this.startDate = LocalDate.now();
    this.isActive = true;
    this.contractTemplate = contractTemplate;
  }

  public Contract() {

  }

  public String getPricingPlan() {
    return "$" + this.contractTemplate.getPrice()
        + " charged per " + this.contractTemplate.getDuration();
  }

  public boolean getIsActive() {
    return isActive;
  }

  public void deactivate() {
    isActive = false;
  }

  public ContractTemplate getContractTemplate() {
    return contractTemplate;
  }

  public LocalDate getStartDate() {
    return startDate;
  }
}
