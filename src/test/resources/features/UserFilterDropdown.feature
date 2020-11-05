Feature: As an authorized user, the Librarian should be able to filter Users from the User Group dropdown
  Background: Login as a librarian
    Given user is on the login page
    When user logs in as a "librarian"

  Scenario: filter table by users
    Given librarian is on the User Management page
    When librarian selects the "Librarian" from User Groups dropdown menu
    Then librarian should be able to see all users on the table are "Librarians"
