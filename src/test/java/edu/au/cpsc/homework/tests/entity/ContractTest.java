/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.tests.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import edu.au.cpsc.homework.entity.Contract;
import edu.au.cpsc.homework.entity.ContractTemplate;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class ContractTest {

  @Test
  public void given_contract_with_contract_template_then_get_pricing_plan() {
    Contract contract = new Contract(ContractTemplate.TRIAL);
    String pricingPlanOutput = contract.getPricingPlan();

    assertEquals("$10 charged per 1 week", pricingPlanOutput);
  }

  @Test
  public void given_new_contract_then_start_date_is_created() {
    Contract contract = new Contract(ContractTemplate.TRIAL);
    LocalDate startDate = contract.getStartDate();

    assertNotNull(contract.getStartDate());
    assertEquals(startDate, contract.getStartDate());
  }

  @Test
  public void give_new_contract_then_template_information_is_correct() {
    Contract contract = new Contract(ContractTemplate.TRIAL);
    String templateName = contract.getContractTemplate().getName();
    String templateDuration = contract.getContractTemplate().getDuration();
    int templatePrice = contract.getContractTemplate().getPrice();
    String templateRequirements = contract.getContractTemplate().getEligibilityRequirements();

    assertEquals("Trial", templateName);
    assertEquals("1 week", templateDuration);
    assertEquals(10, templatePrice);
    assertEquals("Client must never have had a contract before", templateRequirements);
  }

  @Test
  public void given_new_contract_get_name_returns_proper_name() {
    Contract contract = new Contract(ContractTemplate.TRIAL);
    String contractName = contract.getName();

    assertEquals("Trial", contractName);
  }
}
