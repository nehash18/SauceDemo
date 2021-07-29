Feature: Validate SauceDemo

  Background: User is logged in
    Given customer navigates to SauceDemo URL
    When customer submit username and password
    Then customer should be logged in
@test
  Scenario: Successfully verify basket is empty
    When customer click on basket icon
    Then customer verifies basket is empty
