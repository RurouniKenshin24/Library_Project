Feature: Authorized user should be able add new user

  Background: Login as a librarian
    Given user is on the login page
    When user logs in as a "librarian"

    @add_user
  Scenario: Add new user
    Given librarian is on the User Management page
    When user clicks on Add User button
    And user adds new user information
    And clicks Save Changes button
    Then user should be able to see saved user on the list