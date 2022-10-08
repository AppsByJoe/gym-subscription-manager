/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.repository.spring;

import edu.au.cpsc.homework.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface used to update repositories for use with Spring in conjunction with
 * SpringDataClientRepository adapter.
 */
@Repository
public interface SpringDataClientCrudRepository extends CrudRepository<Client, Long> {

}
