@login
Feature: As a user I want to able to login libraryCt under different roles

  Background: Common steps
    Given user is on the login page

  @parametrized_login
  Scenario: Parametrized login
    When user logs in as a "student"
    Then user should be able to see dashboard page

  @negative_test1
  Scenario: Invalid password
    When user logs in with "student43@library" email and "wrong" password
    Then user verifies that "Sorry, Wrong Email or Password" message is displayed

  @librarian_login
  Scenario: Login as a librarian
    When user logs in as a librarian
    Then user should be able to see dashboard page