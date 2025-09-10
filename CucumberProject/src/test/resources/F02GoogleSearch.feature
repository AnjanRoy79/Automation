Feature: Google Search functionality

  Scenario: To validate Google search functionality
    Given I Launch Google
    When Enter Some keyword to search
    And Hit Enter
    Then A valid search result should display
