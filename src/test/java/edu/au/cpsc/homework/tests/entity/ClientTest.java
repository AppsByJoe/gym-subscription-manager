/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.tests.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.au.cpsc.homework.entity.Client;
import edu.au.cpsc.homework.entity.Contract;
import edu.au.cpsc.homework.entity.ContractTemplate;
import org.junit.jupiter.api.Test;

public class ClientTest {

  @Test
  public void given_new_client_list_of_contracts_is_empty() {
    Client client = new Client();
    assertEquals(0, client.getContracts().size());
  }

  @Test
  public void when_contract_added_then_list_has_one_contract() {
    Client client = new Client();
    client.getContracts().add(new Contract(ContractTemplate.TRIAL));
    assertEquals(1, client.getContracts().size());
  }
  @Test
  public void when_client_is_member_get_start_date_string() {
    Client client = new Client();
    client.getContracts().add(new Contract(ContractTemplate.TRIAL));
    String startDate = client.getActiveContractStartDate();
    assertFalse(startDate.isBlank());
  }
  @Test
  public void when_client_is__not_member_get_start_date_empty_string() {
    Client client = new Client();
    String startDate = client.getActiveContractStartDate();
    assertTrue(startDate.isBlank());
  }

  @Test
  public void when_client_is_member_get_template_name_string() {
    Client client = new Client();
    client.getContracts().add(new Contract(ContractTemplate.TRIAL));
    String templateName = client.getActiveContractTemplateName();
    assertFalse(templateName.isBlank());
  }
  @Test
  public void when_client_is__not_member_get_template_name_empty_string() {
    Client client = new Client();
    String templateName = client.getActiveContractTemplateName();
    assertTrue(templateName.isBlank());
  }

  @Test
  public void when_client_is_member_get_pricing_plan_info_string() {
    Client client = new Client();
    client.getContracts().add(new Contract(ContractTemplate.TRIAL));
    String templateName = client.getPricingPlanInfo();
    assertFalse(templateName.isBlank());
  }
  @Test
  public void when_client_is__not_member_get_pricing_plan_info_empty_string() {
    Client client = new Client();
    String templateName = client.getPricingPlanInfo();
    assertTrue(templateName.isBlank());
  }
}
