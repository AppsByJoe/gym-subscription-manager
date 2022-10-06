/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.entity;

import edu.au.cpsc.homework.repository.ClientRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This class generates sample data for all client fields with which to populate the database.
 */
public class SampleDataGenerator {

  /**
   * Creates sample client data and saves it to the passed client repository.
   *
   * @param clientRepository Client repository to receive generated client data.
   */
  public static void generate(ClientRepository clientRepository) {

    Client client1 = new Client();
    client1.setName("John Doe");
    client1.setEmail("john.doe@gmail.com");
    client1.setDateOfBirth(LocalDate.of(1989, 6, 23));
    client1.setStreet("Electric Avenue");
    client1.setCity("New York City");
    client1.setState("New York");
    client1.setZip(67023);
    client1.debugAddEligibleContractToClient(ContractTemplate.TRIAL);
    client1.debugAddEligibleContractToClient(ContractTemplate.SHORT);
    client1.debugAddEligibleContractToClient(ContractTemplate.MEDIUM);
    client1.debugAddEligibleContractToClient(ContractTemplate.LONG);
    List<Client> listOfSampleClients = new ArrayList<>();
    listOfSampleClients.add(client1);

    Client client2 = new Client();
    client2.setName("Susan Smith");
    client2.setEmail("susan.smith@yahoo.com");
    client2.setDateOfBirth(LocalDate.of(1990, 9, 26));
    client2.setStreet("Main Street");
    client2.setCity("Smalltoun");
    client2.setState("Ohio");
    client2.setZip(77298);
    client2.debugAddEligibleContractToClient(ContractTemplate.SHORT);
    listOfSampleClients.add(client2);

    Client client3 = new Client();
    client3.setName("Jackson Pollock");
    client3.setEmail("hackfraud@aol.com");
    client3.setDateOfBirth(LocalDate.of(1902, 3, 8));
    client3.setStreet("Martin Luther King Jr. Boulevard");
    client3.setCity("Cleveland");
    client3.setState("Ohio");
    client3.setZip(33098);
    client3.debugAddEligibleContractToClient(ContractTemplate.TRIAL);
    client3.debugAddEligibleContractToClient(ContractTemplate.SHORT);
    client3.debugAddEligibleContractToClient(ContractTemplate.MEDIUM);
    client3.debugAddEligibleContractToClient(ContractTemplate.MEDIUM);
    client3.debugAddEligibleContractToClient(ContractTemplate.LONG);
    client3.debugAddEligibleContractToClient(ContractTemplate.MEDIUM);
    client3.debugAddEligibleContractToClient(ContractTemplate.MEDIUM);
    listOfSampleClients.add(client3);

    Client client4 = new Client();
    client4.setName("Jean-Luc Picard");
    client4.setEmail("makeitso@federation.net");
    client4.setDateOfBirth(LocalDate.of(2798, 4, 10));
    client4.setStreet("High Street");
    client4.setCity("Austintown");
    client4.setState("Ohio");
    client4.setZip(39755);
    listOfSampleClients.add(client4);

    Client client5 = new Client();
    client5.setName("William Riker");
    client5.setEmail("number_one@federation.net");
    client5.setDateOfBirth(LocalDate.of(2012, 3, 1));
    client5.setStreet("Enterprise Way");
    client5.setCity("Elyria");
    client5.setState("Ohio");
    client5.setZip(90210);
    listOfSampleClients.add(client5);

    Client client6 = new Client();
    client6.setName("Geordi La Forge");
    client6.setEmail("cyclops@federation.net");
    client6.setDateOfBirth(LocalDate.of(1955, 3, 20));
    client6.setStreet("Lakeside Boulevard");
    client6.setCity("Avon");
    client6.setState("Ohio");
    client6.setZip(90210);
    listOfSampleClients.add(client6);

    Client client7 = new Client();
    client7.setName("Tasha Yar");
    client7.setEmail("xXx420xXx@outlook.com");
    client7.setDateOfBirth(LocalDate.of(1999, 9, 9));
    client7.setStreet("Main Street");
    client7.setCity("Akron");
    client7.setState("Ohio");
    client7.setZip(95882);
    listOfSampleClients.add(client7);

    Client client8 = new Client();
    client8.setName("Worf");
    client8.setEmail("worfworfworf@federation.net");
    client8.setDateOfBirth(LocalDate.of(2022, 9, 20));
    client8.setStreet("Honor Rd.");
    client8.setCity("Columbus");
    client8.setState("Ohio");
    client8.setZip(55055);
    client8.debugAddEligibleContractToClient(ContractTemplate.TRIAL);
    client8.debugAddEligibleContractToClient(ContractTemplate.LONG);
    client8.debugAddEligibleContractToClient(ContractTemplate.MEDIUM);
    client8.debugAddEligibleContractToClient(ContractTemplate.SHORT);
    listOfSampleClients.add(client8);

    Client client9 = new Client();
    client9.setName("Beverly Crusher");
    client9.setEmail("1337haxx0r@federation.net");
    client9.setDateOfBirth(LocalDate.of(1976, 4, 29));
    client9.setStreet("Court St.");
    client9.setCity("Athens");
    client9.setState("Ohio");
    client9.setZip(13948);
    listOfSampleClients.add(client9);

    Client client10 = new Client();
    client10.setName("Deanna Troi");
    client10.setEmail("harlem_shake@yahoo.com");
    client10.setDateOfBirth(LocalDate.of(1964, 10, 30));
    client10.setStreet("Sahara Avenue");
    client10.setCity("Las Vegas");
    client10.setState("Nevada");
    client10.setZip(33407);
    listOfSampleClients.add(client10);

    Client client11 = new Client();
    client11.setName("Robert'); DROP TABLE Clients;--");
    client11.setEmail("bobby.droptables@xkcd.com");
    client11.setDateOfBirth(LocalDate.of(2007, 3, 17));
    client11.setStreet("Wall Street");
    client11.setCity("New York City");
    client11.setState("New York");
    client11.setZip(77108);
    client11.debugAddEligibleContractToClient(ContractTemplate.TRIAL);
    client11.debugAddEligibleContractToClient(ContractTemplate.SHORT);
    client11.debugAddEligibleContractToClient(ContractTemplate.STUDENT);
    client11.debugAddEligibleContractToClient(ContractTemplate.STUDENT);
    client11.debugAddEligibleContractToClient(ContractTemplate.STUDENT);
    listOfSampleClients.add(client11);

    Client client12 = new Client();
    client12.setName("Robert Baratheon");
    client12.setEmail("bobby_b@kingslanding.com");
    client12.setDateOfBirth(LocalDate.of(1138, 9, 20));
    client12.setStreet("Cobblestone Court");
    client12.setCity("King's Landing");
    client12.setState("Ohio");
    client12.setZip(44234);
    client12.debugAddEligibleContractToClient(ContractTemplate.TRIAL);
    client12.debugAddEligibleContractToClient(ContractTemplate.MEDIUM);
    client12.debugAddEligibleContractToClient(ContractTemplate.LONG);
    client12.debugAddEligibleContractToClient(ContractTemplate.LONG);
    client12.debugAddEligibleContractToClient(ContractTemplate.SHORT);
    client12.debugAddEligibleContractToClient(ContractTemplate.LONG);
    client12.debugAddEligibleContractToClient(ContractTemplate.LONG);
    client12.debugAddEligibleContractToClient(ContractTemplate.LONG);
    client12.debugAddEligibleContractToClient(ContractTemplate.LONG);
    client12.debugAddEligibleContractToClient(ContractTemplate.LONG);
    client12.debugAddEligibleContractToClient(ContractTemplate.LONG);
    listOfSampleClients.add(client12);

    Client client13 = new Client();
    client13.setName("Jack Ryan");
    client13.setEmail("j.ryan@gmail.com");
    client13.setDateOfBirth(LocalDate.of(1972, 11, 23));
    client13.setStreet("Euclid");
    client13.setCity("Cleveland");
    client13.setState("Ohio");
    client13.setZip(54883);
    client13.debugAddEligibleContractToClient(ContractTemplate.TRIAL);
    client13.debugAddEligibleContractToClient(ContractTemplate.SHORT);
    client13.debugAddEligibleContractToClient(ContractTemplate.MEDIUM);
    client13.debugAddEligibleContractToClient(ContractTemplate.SHORT);
    client13.debugAddEligibleContractToClient(ContractTemplate.SHORT);
    listOfSampleClients.add(client13);

    for (Client c : listOfSampleClients) {
      clientRepository.save(c);
    }
  }
}
