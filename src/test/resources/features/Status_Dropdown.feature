Feature: As a Librarian, user should be able to filter User's status from the Status dropdown

  @status_dropdown
  Scenario: Librarian should be able to filter User's status
    Given user is on the User Management page
    When user selects "50" from Records dropdown
    Then user should see all user's status are "ACTIVE"
    When user selects "INACTIVE" from Status dropdown
    And user selects "50" from Records dropdown
    Then user should see all user's status are "INACTIVE"