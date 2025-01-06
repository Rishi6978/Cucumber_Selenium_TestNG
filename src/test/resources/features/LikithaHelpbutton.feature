Feature: Admin Tab vrifications


  Background:
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"


  Scenario: Clicking the help button and closing the tab to return to the dashboard

    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login successfully and new page open
    Then User clicks on help button
    Then User is navigated to a new window to perform some actions
    Then User closes the new window
    Then User returns to the original window