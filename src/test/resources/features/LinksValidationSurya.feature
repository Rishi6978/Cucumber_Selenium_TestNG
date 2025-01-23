@smoke
Feature: Validate all links on the webpage

  Background:
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"

  @ValidLinks @smoke
  Scenario: Validate all links on the Dashboard page

    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login successfully and new page open
    And User captures and validates all links on the Dashboard page
