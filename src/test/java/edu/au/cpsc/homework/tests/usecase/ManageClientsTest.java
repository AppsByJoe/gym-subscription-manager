/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.tests.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.au.cpsc.homework.entity.Client;
import edu.au.cpsc.homework.entity.ContractTemplate;
import edu.au.cpsc.homework.entity.SampleDataGenerator;
import edu.au.cpsc.homework.repository.ClientRepository;
import edu.au.cpsc.homework.usecase.ManageClients;
import java.time.LocalDate;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Transactional
public abstract class ManageClientsTest {

  protected ClientRepository clientRepository;

  protected ManageClients useCase;

  private static void setDefaultClientValues(Client client) {
    client.setName("name");
    client.setEmail("name@address.com");
    client.setDateOfBirth(LocalDate.of(2022, 9, 20));
    client.setStreet("streetName");
    client.setCity("cityName");
    client.setState("stateName");
    client.setZip(90210);
  }

  public abstract void createRepository();

  @BeforeEach
  public void setUp() {
    createRepository();
    useCase = new ManageClients(clientRepository);
  }

  @Test
  public void given_no_clients_then_none_listed() {
    var clients = useCase.getClients();
    assertEquals(0, clients.size());
  }

  @Test
  public void given_two_clients_then_two_listed() {
    Client client1 = new Client();
    setDefaultClientValues(client1);
    useCase.addEligibleContractToClient(client1, ContractTemplate.TRIAL);
    clientRepository.save(client1);
    Client client2 = new Client();
    setDefaultClientValues(client2);
    useCase.addEligibleContractToClient(client2, ContractTemplate.TRIAL);
    clientRepository.save(client2);

    List<Client> clientList = useCase.getClients();
    assertEquals(2, clientList.size());
  }

  @Test
  public void given_client_with_contract_when_new_contract_added_old_deactivated() {
    Client client = new Client();
    setDefaultClientValues(client);
    useCase.addEligibleContractToClient(client, ContractTemplate.TRIAL);
    useCase.addEligibleContractToClient(client, ContractTemplate.SHORT);

    assertFalse(client.getContracts().get(0).getIsActive());
  }

  @Test
  public void given_client_with_contract_when_new_contract_added_then_it_is_at_end_of_list() {
    Client client = new Client();
    setDefaultClientValues(client);
    useCase.addEligibleContractToClient(client, ContractTemplate.TRIAL);
    useCase.addEligibleContractToClient(client, ContractTemplate.SHORT);

    assertEquals(ContractTemplate.SHORT, client.getLatestContractTemplate());
  }

  @Test
  public void given_client_return_list_of_eligible_enum_templates() {
    Client client = new Client();
    setDefaultClientValues(client);
    client.setDateOfBirth(LocalDate.of(1999, 9, 20));
    useCase.addEligibleContractToClient(client, ContractTemplate.TRIAL);
    var list = useCase.getEligibleTemplates(client);

    assertEquals(3, list.size());
  }

  @Test
  public void when_called_generate_adds_sample_data_to_repository() {
    int oldSize = clientRepository.findAll().size();
    SampleDataGenerator.generate(clientRepository);
    int newSize = clientRepository.findAll().size();

    assertTrue(oldSize < newSize);
  }

  @Test
  public void when_saved_client_can_be_retrieved() {
    Client client = new Client();
    setDefaultClientValues(client);
    String oldName = client.getName();

    useCase.saveClient(client);
    assertEquals(oldName, client.getName());
  }
}
