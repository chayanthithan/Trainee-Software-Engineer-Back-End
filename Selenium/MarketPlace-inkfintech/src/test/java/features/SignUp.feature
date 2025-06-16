Feature: SignIn User
  Scenario: validate user is able to sign in after sign up
    Given User navigates to the sign up page
    When User successfully enters the sign up details
    Then User Should be able to view home page