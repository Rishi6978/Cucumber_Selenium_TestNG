@smoke
Feature: Login to HRM Application


  Background:
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"



  @ValidCredentials @smoke
  Scenario: Login with valid credentials and navigate to myinfo page and verify records

    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login successfully and new page open
    Then user navigates to myinfo page
    Then user navigates to "Dashboard"
#    Then user verify My Action
#    Then user navigates to myinfo page


  Then user navigates to help





# add data ia and edit toggle






