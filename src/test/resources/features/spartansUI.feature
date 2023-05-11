Feature: Manage Spartans Army

  Agile Story: As the commander of the army, I should manage my soldiers, so that I can win.


  Background: Navigate to main page
    Given Commander is at the main page


  Scenario: Displaying selected Spartans info
    When Commander clicks on the view button with the Spartan ID number "3"
    Then Verifies the name of Spartan is "Fidole"

  @wip
  Scenario Outline: Viewing selected Spartans Info
    When Commander clicks on the view button with the Spartan ID number "<id>"
    Then Verifies the name of Spartan is "<name>"
    Examples:
      | id | name    |
      | 3  | Fidole  |
      | 7  | Hershel |
      | 10 | Lorenza |
      | 21 | Mark    |


