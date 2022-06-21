@FirstTest
Feature: Basic syntax
  @BasicScenario1
  Scenario: Scenario1
    Given user is on the TS homepage
    When user clicks on about us link
    Then they are redirected to About us page
    And we verify if they are on the page
    Then Close the browser
