# new feature
# Tags: optional

Feature: I want to be able to search users by Full Name, Email, and User ID
Background: Login as a librarian
  Given user is on the login page
  When user logs in as a "librarian"

  Scenario Outline: Search by <search term>
    Given librarian is on the User Management page
    When user enters "<search term>" into the Search input
    Then user should see only results that contain "<search term>" in Full Name, Email, or User ID
    Examples:
      |search term|
      |test       |
      |asd        |