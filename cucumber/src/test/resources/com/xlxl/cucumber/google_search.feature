@selenium
Feature: Google search result should be correct

  Scenario Outline: Search for cucumber
    Given I am on the Google search page
    When I search for "<query>"
    Then The page title should start with "<query>"
    And "<query>" is displayed in any of the first <val> results with css title selector "<selector>"

    Examples:
      | query    | val | selector |
      | illinois |  3  |  a h3    |
      | cucumber |  5  |  h2      |