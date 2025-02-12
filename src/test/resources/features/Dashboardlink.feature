Feature: Check Dashboard Links Status

  Background:
    Given User is on the HRM Login page "https://opensource-demo.orangehrmlive.com/"

  Scenario: User logs in and verifies the status of links on the dashboard
    Given User enters username as "Admin" and password as "admin123"
    When User navigates to the dashboard page
    Then User verifies that all links on the dashboard are functional