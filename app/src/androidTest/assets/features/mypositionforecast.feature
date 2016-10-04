Feature: I want to get forecasts of my position

  @go
  Scenario Outline: Show my weather and forecast in "Poplar" (change the name of the place of your GPS network)
    Given I am on the main page
    When I click on GPS icon
    Then I should see <MYPOSITION> on the display

    Examples:
      | MYPOSITION |
      | "Poplar" |


