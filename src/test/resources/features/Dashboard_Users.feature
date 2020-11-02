Feature: Users Page
  Scenario: Librarian clicks Users
    Given user is on Dashboard page
    When user clicks "Users" button
    Then user should see "User Management" page