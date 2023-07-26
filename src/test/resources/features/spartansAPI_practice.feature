Feature: Check Spartan Api Results

  @api_practice
  Scenario: Check the Api Response for one Spartan
    When Send A Get Request with the id of 101
    Then Assert response body "Mikey2"
    And Check with HamcrestMatchers
