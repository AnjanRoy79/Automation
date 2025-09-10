Feature: Registration process

  Scenario: To validate registration process
    Given Launch the registration page
    When I enter following data
      | Abhay  | Giri  | abhay@gmail.com  | 9898989898 | Amravati |
      | Bindu  | Kumar | bindu@gmail.com  | 7878787878 | Banglore |
      | Deepak | Ray   | deepak@gmail.com | 8989898989 | Noida    |
    Then Registration should successful

  Scenario: To validate registration process new
    Given Launch registration page in browser
    When I will enter following data
      | FirstName | LastName | Email           | Phone      | Address  |
      | Anjan     | Roy      | anjan@gmail.com | 7878787878 | Kolkata  |
      | Rani      | Shavari  | rani@gmail.com  | 8989898989 | Akkalkot |
    Then Registration should be successful
