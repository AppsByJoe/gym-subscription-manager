/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.usecase;

import edu.au.cpsc.homework.entity.Client;
import edu.au.cpsc.homework.entity.Contract;
import edu.au.cpsc.homework.entity.ContractTemplate;
import edu.au.cpsc.homework.repository.ClientRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * The use case which governs adding, editing, and viewing clients.  Also governs the use case of
 * selecting from contract templates available to a client and assigning them to that client.
 */
@Component
public class ManageClients {

  private final ClientRepository clientRepository;

  public ManageClients(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  /**
   * Returns a list of clients available in the JPA client repository.
   *
   * @return List of clients
   */
  public List<Client> getClients() {
    return new ArrayList<>(clientRepository.findAll());
  }

  /**
   * Takes as input a client object and contract template enumerated type.  This method assumes the
   * client has already been verified as eligible to receive a contract of type contractTemplate.
   * This method deactivates the currently active contract of the client, if applicable.
   *
   * @param client           The client object to receive a new contract.
   * @param contractTemplate The enumerated type denoting a type of contract to instantiate.
   */
  public void addEligibleContractToClient(Client client, ContractTemplate contractTemplate) {
    if (client.isCurrentlyMember()) {
      client.getLatestContract().deactivate();
    }
    Contract contract = new Contract(contractTemplate);
    client.getContracts().add(contract);
  }

  /**
   * Returns a list of eligible templates for a particular client.
   *
   * @param client Client object to be assessed for eligibility
   * @return ArrayList of ContractTemplate objects for which the Client is eligible
   */
  public ArrayList<ContractTemplate> getEligibleTemplates(Client client) {
    ArrayList<ContractTemplate> templateList =
        new ArrayList<>(Arrays.asList(ContractTemplate.values()));
    if (!client.getContracts().isEmpty()) {
      templateList.remove(ContractTemplate.TRIAL);
    }
    LocalDate cutOffDate = LocalDate.now().minusYears(22);
    if (client.getDateOfBirth().isBefore(cutOffDate)) {
      templateList.remove(ContractTemplate.STUDENT);
    }
    return templateList;
  }

  public void saveClient(Client c) {
    clientRepository.save(c);
  }

  /**
   * Cancels current active contract, if applicable.
   *
   * @param client Member whose active contract is to be deactivated
   */
  public void cancelCurrentActiveContract(Client client) {
    if (client.isCurrentlyMember()) {
      client.getLatestContract().deactivate();
    }
  }
}
