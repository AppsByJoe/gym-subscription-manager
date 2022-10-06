/*
 * Copyright (c) 2022. AppsByJoe. See LICENSE.txt for complete copyright information.
 */

package edu.au.cpsc.homework.tests;

import edu.au.cpsc.homework.App;
import org.junit.jupiter.api.Test;

public class AppTest {
  @Test
  public void when_100_percent_code_coverage_needed_test_spring_boot_app_loads() {
    App.main(new String[0]);
  }
}
