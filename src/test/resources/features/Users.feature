@users
  Feature: As a user I want to be able to use users feature properly

    Background: Common steps
      Given user is on the login page
      When user logs in as a "librarian"

    @recordNumber_test
    Scenario: Selecting records test
      Given user is on the "Users" page
      When user selects "users" record as a "10" from dropdown
      Then user should be able to see the "10" numbers of "users" records on the table