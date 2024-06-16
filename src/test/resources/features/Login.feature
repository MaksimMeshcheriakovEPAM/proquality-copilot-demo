Feature: Login Feature
  As a user
  I want to login to the application
  So that I can access my account

  Scenario: Successful Login with Valid Credentials
    Given I am on the login page
    When I login with valid credentials
    Then I should be redirected to the home page