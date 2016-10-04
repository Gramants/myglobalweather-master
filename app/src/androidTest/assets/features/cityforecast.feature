Feature: I want to get forecasts for a city typing the initial part of the name

@go
  Scenario Outline: Show weather and forecast in "Lugo"
    Given I am on the main page
    When I type <MYSEARCH> in the search field
    And I click on <MYITEM> in the list
    Then I should see <MYITEM> on the display

Examples:
  | MYSEARCH  | MYITEM  |
  | "lug" | "Lugo" |

