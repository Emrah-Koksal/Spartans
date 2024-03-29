Feature: Check API Results

  @api @db
  Scenario: Compare UI - API - DB Result
    Given Commander is at the main page
    When Commander clicks on the view button with the Spartan ID number "4"
    When User send a request to API with the ID of 4
    Then Reply from the API should be the same as UI
    When User gets info of the Spartan with id of 4
    Then Spartan name should be "Paige"


  Scenario Outline:

    Then Assert API results with the info of Spartan's <id> ,  "<name>" , "<gender>" and "<phone>"
    Examples:
      | id | name    | gender | phone      |
      | 4  | Paige   | Female | 3786741487 |
      | 10 | Lorenza | Female | 3312820936 |
      | 11 | Nona    | Female | 7959094216 |
      | 12 | Sol     | Male   | 7006438852 |


  Scenario: Test API results using Hamcrest - Chaining
    When User checks and asserts API replies using the Spartan with the ID of 15


  Scenario Outline:
    And Assert API results using Hamcrest with the info of Spartan's <id> ,  "<name>" , "<gender>" and <phone>
    Examples:
      | id | name   | gender | phone      |
      | 1  | Meade  | Male   | 3584128232 |
      | 2  | Nels   | Male   | 4218971348 |
      | 3  | Fidole | Male   | 6105035231 |

  @api1
  Scenario: Test API results using De-Serialization
    When User checks and asserts API replies using De-Serialization Map Method of a Spartan with the ID of 1 and name "Meade"


  Scenario: Test API results using POJO Class
    When User checks and asserts API replies using POJO of a Spartan with the ID of 5


  Scenario: Test API results using GSON Library
    When User checks and asserts API replies using GSON of a Spartan with the ID of 5