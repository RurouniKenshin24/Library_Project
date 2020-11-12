Feature:  Authorized user Librarian is able to Edit User Information

  Background: Login as a librarian
   Given user is on the login page
    When user logs in as a "librarian"

    @EditUser
  Scenario: Edit user Information
    Given librarian is on the User Management page
    When user click to  Edit User button
    And user change all user information
    And user click Save change Button
    Then user should be able to see saved user information on the list

      @DataTables
      Scenario: Edit user Information
        Given librarian is on the User Management page
        When user click to  Edit User button
        And user change all user information
        And user click Save change Button
        Then user should be able to see saved user information on the list
