/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework;

import edu.au.cpsc.homework.entity.Client;
import edu.au.cpsc.homework.entity.SampleDataGenerator;
import edu.au.cpsc.homework.repository.ClientRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * Main driver class.
 */
@SpringBootApplication
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  /**
   * This bean will generate and populate the database with sample data if empty at runtime.
   *
   * @param clientRepository The repository to check if empty and populate with data
   * @return CommandLineRunner bean
   */
  @Bean
  @Profile("production")
  public CommandLineRunner generateSampleData(ClientRepository clientRepository) {
    return (args) -> {
      List<Client> repoAsList = new ArrayList<>();
      for (Client client : (clientRepository.findAll())) {
        repoAsList.add(client);
      }
      if (repoAsList.isEmpty()) {
        SampleDataGenerator.generate(clientRepository);
      }
    };
  }
}

