Feature: Check Spartan Api Results

  @api @db
  Scenario: Compare UI - API - DB Result
    Given Commander is at the main page
    When Commander clicks on the view button with the Spartan ID number "4"
    When User send a request to API with the ID of 4
    Then Reply from the API should be the same as UI
    When User gets info of the Spartan with id of 4
    Then Spartan name should be "Paige"

