Feature: Search City

  Background:
    Given I am on the AccuWeather webpage

  Scenario: Search using city name
    When I type 'London' on the search bar
    And I click on the first result
    Then the weather page for 'London' should be displayed

  Scenario Outline: Search using current location
    Given my current location is '<location>'
    When I click the search bar
    And I click the current location label
    Then the weather page for '<location>' should be displayed

    Examples:
    | location       |
    | Montevideo     |
    | Buenos Aires   |
