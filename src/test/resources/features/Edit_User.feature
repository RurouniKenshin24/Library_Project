Feature: I should be able to Edit User
  Background: Login as a librarian
    Given user is on the login page
    When user logs in as a librarian

@UserEditSteps
  Scenario:  As an authorized user, the Librarian should be able to Edit User
    When  i should able to click user button
    And i should able to click to edit user button
    And i should edit user name
    Then i should click to save changes

