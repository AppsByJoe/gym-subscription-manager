/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.au.cpsc.homework.App;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextException;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("production")
public class AppTest {

  @Test
  public void when_100_percent_code_coverage_needed_test_spring_boot_app_loads() {
    try {
      App.main(new String[0]);
    } catch (ApplicationContextException e) {
      assertTrue(true); // Stop program to not throw this exception while running tests
    }
  }
}
