
Feature: Users Page
  Background: Login as a librarian
    Given user is on the login page
    When user logs in as a "librarian"

  Scenario: Librarian clicks Users
    When user clicks "Users" button
    Then user should see "User Management" page