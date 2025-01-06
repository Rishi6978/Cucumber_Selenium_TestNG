@smoke
Feature: Validate Information on Help Page

  Background:
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"

  @ValidCredentials @smoke
  Scenario: User opens the Help Page, validates the information and closes the tab

    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login successfully and new page open
    And User clicks on the Help icon
    Then new Tab opens with help information
    And User validates information on the Help page
    Then User closes the help tab and returns to home page tab
