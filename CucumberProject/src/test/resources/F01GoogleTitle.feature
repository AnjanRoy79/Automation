Feature: Google Title

  Scenario: To Validate Google Title
    Given Launch Google
    When Read the Title
    And Display the Title
    Then Title should be Google