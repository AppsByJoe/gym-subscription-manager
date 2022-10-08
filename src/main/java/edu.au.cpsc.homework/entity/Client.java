/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Defines client objects, people who have been documented in the database with 0 or more
 * contracts.
 */
@javax.persistence.Entity
public class Client extends Entity {

  @NotBlank
  private String name;
  private String email;

  private LocalDate dateOfBirth;
  @NotBlank
  private String street;
  @NotBlank
  private String city;
  @NotBlank
  private String state;
  @NotNull
  private int zip;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List<Contract> contracts;

  public Client() {
    contracts = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public int getZip() {
    return zip;
  }

  public void setZip(int zip) {
    this.zip = zip;
  }

  public List<Contract> getContracts() {
    return this.contracts;
  }

  public ContractTemplate getLatestContractTemplate() {
    return contracts.get(contracts.size() - 1).getContractTemplate();
  }

  public boolean isCurrentlyMember() {
    return !contracts.isEmpty() && contracts.get(contracts.size() - 1).getIsActive();
  }

  public Contract getLatestContract() {
    return contracts.get(contracts.size() - 1);
  }

  /**
   * Takes as input the contract template enumerated type.  This method assumes the client has
   * already been verified as eligible to receive a contract of type contractTemplate. This method
   * deactivates the currently active contract of the client, if applicable.
   *
   * @param contractTemplate The enumerated type denoting a type of contract to instantiate.
   */
  public void debugAddEligibleContractToClient(ContractTemplate contractTemplate) {
    if (this.isCurrentlyMember()) {
      contracts.get(contracts.size() - 1).deactivate();
    }
    Contract contract = new Contract(contractTemplate);
    contracts.add(contract);
  }

  public String getActiveContractTemplateName() {
    if (isCurrentlyMember()) {
      return getLatestContractTemplate().getName();
    } else {
      return "";
    }
  }

  public String getActiveContractStartDate() {
    if (isCurrentlyMember()) {
      return getLatestContract().getStartDate().toString();
    } else {
      return "";
    }
  }

  public String getPricingPlanInfo() {
    if (isCurrentlyMember()) {
      return getLatestContract().getPricingPlan();
    } else {
      return "";
    }
  }
}
