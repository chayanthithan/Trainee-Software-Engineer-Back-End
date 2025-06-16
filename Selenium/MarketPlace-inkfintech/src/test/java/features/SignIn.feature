Feature: SignIn User
  Scenario: validate user is able to view after login
    Given User navigates to the login page
    When User successfully enters the login details
    Then User Should be able to view dashboard page