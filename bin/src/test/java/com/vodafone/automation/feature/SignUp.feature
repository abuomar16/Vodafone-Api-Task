Feature: Sign Up

  Scenario: Verify that user can sign up successfully

    Given I am on the demoblaze sign up page
    When I click on the Sign Up button
    And I fill in the sign up form with valid username and password
    And I submit the form
    Then I should see the message "Sign up successful."
