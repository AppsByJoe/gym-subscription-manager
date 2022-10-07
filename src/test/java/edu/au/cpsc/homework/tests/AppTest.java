/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.tests;

import edu.au.cpsc.homework.App;
import edu.au.cpsc.homework.entity.Client;
import edu.au.cpsc.homework.repository.ClientRepository;
import edu.au.cpsc.homework.repository.spring.SpringDataClientCrudRepository;
import edu.au.cpsc.homework.repository.spring.SpringDataClientRepository;
import edu.au.cpsc.homework.usecase.ManageClients;
import javax.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.BeforeTestClass;

// annotations test bean outside normal test profile
@SpringBootTest
//@Transactional
@ActiveProfiles("production")
public class AppTest {


  protected ClientRepository clientRepository;

  protected ManageClients useCase;
  private SpringDataClientRepository springDataClientRepository;

  @Autowired
  public void setSpringDataClientRepository(SpringDataClientRepository springDataClientRepository) {
    this.springDataClientRepository = springDataClientRepository;
  }
  public void createRepository() {
    clientRepository = springDataClientRepository;
  }

  @BeforeEach
  public void setUp() throws Exception {
    createRepository();
    clientRepository.findAll().removeAll(clientRepository.findAll());

    useCase = new ManageClients(clientRepository);
    for (Client c : clientRepository.findAll()) {
      System.out.println(c.getName());
    }
  }

  @Test
  public void when_100_percent_code_coverage_needed_test_spring_boot_app_loads() {
    App.main(new String[0]);
  }
}
