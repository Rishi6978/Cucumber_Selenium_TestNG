Feature: Validate Read links feature in OrangeHRM

  Background:
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"

  Scenario: User accesses the dashboard page and validates all the Read links
    Given User enters username as "Admin" and password as "admin123"
    When User navigates to the dashboard page and validates all the Read links present on the dashboard page
