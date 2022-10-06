/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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
  @NotNull
  private LocalDate dateOfBirth;
  @NotBlank
  private String street;
  @NotBlank
  private String city;
  @NotBlank
  private String state;
  @NotNull
  private int zip;

  @OneToMany(cascade = CascadeType.ALL)
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
}
