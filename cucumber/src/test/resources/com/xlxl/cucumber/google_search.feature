@selenium
Feature: Google search result should start correctly

  Scenario: Finding some cucumber
    Given I am on the Google search page
    When I search for "cucumber"
    Then the page title should start with "cucumber"