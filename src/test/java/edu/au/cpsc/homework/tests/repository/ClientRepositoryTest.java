/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.tests.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import edu.au.cpsc.homework.entity.Client;
import edu.au.cpsc.homework.repository.ClientRepository;
import java.time.LocalDate;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Transactional
public abstract class ClientRepositoryTest {

  private ClientRepository repository;

  private static void setDefaultClientValues(Client client) {
    client.setName("name");
    client.setEmail("name@address.com");
    client.setDateOfBirth(LocalDate.of(2022, 9, 20));
    client.setStreet("streetName");
    client.setCity("cityName");
    client.setState("stateName");
    client.setZip(90210);
  }

  protected abstract ClientRepository createRepository();

  @BeforeEach
  public void setUp() {
    repository = createRepository();
  }

  @Test
  public void when_no_clients_then_find_all_returns_empty_list() {
    List<Client> clientList = repository.findAll();
    assertEquals(0, clientList.size());
  }

  @Test
  public void when_client_saved_original_id_same_as_returned_id() {
    Client client = new Client();
    setDefaultClientValues(client);

    Long id = repository.save(client);
    assertNotNull(client.getId());
    assertEquals(id, client.getId());
  }

  @Test
  public void when_client_saved_twice_id_not_changed() {
    Client client = new Client();
    setDefaultClientValues(client);

    repository.save(client);
    Long oldId = client.getId();
    repository.save(client);
    assertEquals(oldId, client.getId());
  }

  @Test
  public void when_no_client_saved_then_null_returned_from_find_one() {
    Client client = repository.findOne(1L);
    assertNull(client);
  }

  @Test
  public void when_client_saved_then_returned_from_find_one() {
    Client client = new Client();
    setDefaultClientValues(client);

    Long id = repository.save(client);
    Client clientFromRepository = repository.findOne(id);
    assertEquals(id, clientFromRepository.getId());
    assertEquals("name", clientFromRepository.getName());
    assertEquals("name@address.com", clientFromRepository.getEmail());
    assertEquals(LocalDate.of(2022, 9, 20), clientFromRepository.getDateOfBirth());
    assertEquals("streetName", clientFromRepository.getStreet());
    assertEquals("cityName", clientFromRepository.getCity());
    assertEquals("stateName", clientFromRepository.getState());
    assertEquals(90210, clientFromRepository.getZip());
  }

  @Test
  public void when_client_saved_then_returned_from_find_all() {
    Client oldClient = new Client();
    setDefaultClientValues(oldClient);
    Long id = repository.save(oldClient);

    List<Client> clientList = repository.findAll();
    Client client = clientList.get(0);
    assertEquals(1, clientList.size());
    assertEquals(id, client.getId());
    assertEquals("name", client.getName());
    assertEquals("name@address.com", client.getEmail());
    assertEquals(LocalDate.of(2022, 9, 20), client.getDateOfBirth());
    assertEquals("streetName", client.getStreet());
    assertEquals("cityName", client.getCity());
    assertEquals("stateName", client.getState());
    assertEquals(90210, client.getZip());
  }

  @Test
  public void when_two_clients_saved_then_two_returned_from_find_all() {
    Client client1 = new Client();
    setDefaultClientValues(client1);
    repository.save(client1);
    Client client2 = new Client();
    setDefaultClientValues(client2);
    repository.save(client2);

    List<Client> clientList = repository.findAll();
    assertEquals(2, clientList.size());
  }
}
