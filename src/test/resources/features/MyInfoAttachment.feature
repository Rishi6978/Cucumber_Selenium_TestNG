Feature: myInfo Tab verifications


  Background:
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"


  Scenario: Creating new role for employee

    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login successfully and new page open
    Then User navigates to MyInfo page
    Then User clicks on add button for attachments
    Then User attaches a file and clicks on save button
    Then User verifies the attachment is saved
