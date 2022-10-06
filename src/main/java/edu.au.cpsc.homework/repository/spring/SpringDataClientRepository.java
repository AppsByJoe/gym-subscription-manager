/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.repository.spring;

import edu.au.cpsc.homework.entity.Client;
import edu.au.cpsc.homework.repository.ClientRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class SpringDataClientRepository implements ClientRepository {
  private final SpringDataClientCrudRepository springDataClientCrudRepository;

  public SpringDataClientRepository(SpringDataClientCrudRepository springDataClientCrudRepository) {
    this.springDataClientCrudRepository = springDataClientCrudRepository;
  }

  @Override
  public List<Client> findAll() {
    List<Client> output = new ArrayList<>();
    for (Client c : springDataClientCrudRepository.findAll()) {
      output.add(c);
    }
    return output;
  }

  @Override
  public Long save(Client entity) {
    return springDataClientCrudRepository.save(entity).getId();
  }

  @Override
  public Client findOne(Long id) {
    return springDataClientCrudRepository.findById(id).orElse(null);
  }
}
