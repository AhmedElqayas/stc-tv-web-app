Feature: Check subscription plans for each country option
  Description: checking the plan title, its price and currency for each country in the countries popup

  @TC_01
  Scenario: Validating the subscription plan
    Given user is on subscription page
    Then each plan should have the correct details for the corresponding country