/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.tests.repository;

import edu.au.cpsc.homework.repository.ClientRepository;
import edu.au.cpsc.homework.repository.spring.SpringDataClientRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

@DataJpaTest
@Transactional
@ComponentScan("edu.au.cpsc.homework")
public class SpringDataClientRepositoryTest extends ClientRepositoryTest {

  private SpringDataClientRepository springDataClientRepository;

  @Autowired
  public void setSpringDataClientRepository(SpringDataClientRepository springDataClientRepository) {
    this.springDataClientRepository = springDataClientRepository;
  }

  @Override
  protected ClientRepository createRepository() {
    return springDataClientRepository;
  }
}
