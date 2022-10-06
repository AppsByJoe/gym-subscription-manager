/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.repository;

import edu.au.cpsc.homework.entity.Entity;
import java.util.List;

/**
 * Defines the generic types of things any repository can do.
 *
 * @param <T> The generic entity type to be implemented by relevant subclasses
 */
public interface Repository<T extends Entity> {

  List<T> findAll();

  Long save(T entity);

  T findOne(Long id);
}
