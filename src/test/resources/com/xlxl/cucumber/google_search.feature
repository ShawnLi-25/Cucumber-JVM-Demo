Feature: Google search result should start correctly

  Scenario: Finding some cheese
    Given I am on the Google search page
    When I search for "cucumber"
    Then the page title should start with "cucumber"