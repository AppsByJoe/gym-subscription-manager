/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.tests.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
