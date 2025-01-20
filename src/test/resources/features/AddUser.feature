@smoke
Feature: Add User to Admin User Management


  Background:
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"

  @ValidCredentials @smoke
  Scenario: Login with valid credentials and navigate to Admin page and Add User

    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login successfully and new page open
    Then user navigates to myinfo page
    Then user navigates to "Admin"
    Then Add User to Admin User Management
