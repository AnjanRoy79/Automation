Feature: OHRM Login

  Background: // As two sceneriao have same launching browser function in given statement.
    Given Launch OHRM

  Scenario: To validate login functionality with valid data
    When Enter valid userName
    When Enter valid password
    And Click on Login button
    Then Dashboard page should display

  Scenario: To validate login functionality with invalid data
    When Enter invalid username
    When Enter invalid password
    And Click on submit button
    Then Error message should display
