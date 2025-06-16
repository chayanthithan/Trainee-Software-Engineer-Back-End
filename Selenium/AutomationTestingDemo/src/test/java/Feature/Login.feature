Feature: validate login credentials
  Scenario: validate that user able to login
    Given user navigate to login page
    When  user enter valid credentials
    Then  user able to redirect to dashboard page
    And the "Get Started" popup should be visible
    When user clicks "Add Store" in the popup
    Then the store creation interface should be displayed