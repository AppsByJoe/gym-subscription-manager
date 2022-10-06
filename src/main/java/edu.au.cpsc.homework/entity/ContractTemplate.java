/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.entity;

/**
 * This class provides a concise way of defining types of contracts that can be created using the
 * Contract class.
 */
public enum ContractTemplate {
  TRIAL("Trial", "1 week", 10, "Client must never have had a contract before"),
  SHORT("Short", "1 month", 25, "No requirements"),
  STUDENT("Student", "3 months", 25, "Client must be under 22 years old"),
  MEDIUM("Medium", "6 months", 110, "No requirements"),
  LONG("Long", "1 year", 200, "No requirements");

  private final String name;
  private final String duration;
  private final int price;
  private final String eligibilityRequirements;

  ContractTemplate(String name, String duration, int price, String eligibilityRequirements) {
    this.name = name;
    this.duration = duration;
    this.price = price;
    this.eligibilityRequirements = eligibilityRequirements;
  }

  public int getPrice() {
    return this.price;
  }

  public String getDuration() {
    return this.duration;
  }

  public String getEligibilityRequirements() {
    return eligibilityRequirements;
  }

  public String getName() {
    return name;
  }
}
