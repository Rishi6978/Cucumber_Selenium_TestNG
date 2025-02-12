Feature: Dashboard Activities

  @ValidCredentials
  Scenario: Listing down activities under My Actions
    Given the user is on the dashboard page
    When the user checks the actions listed under My Actions
    Then the user should see the following activities listed:
      | activity                     |
      | Pending Self Review          |
      | Candidate to Interview       |