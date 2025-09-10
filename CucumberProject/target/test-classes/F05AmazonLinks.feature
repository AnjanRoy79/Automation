@AllLinks
Feature: Amazon Links

  Background: 
    Given Launch Amazon site
@SellLink 
  Scenario: Test Sell link
    When Click on Sell link
    Then Sell page should display
@BestSell
  Scenario: Test Bestsellers link
    When Click on BestSellers link
    Then Bestsellers page should display
@Mobile
  Scenario: Test Mobiles link
    When Click on Mobiles link
    Then Mobiles page should display
@Deal
  Scenario: Test Todays deal link
    When Click on Todays deal link
    Then Todays deal page should display
