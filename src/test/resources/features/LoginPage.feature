@smoke
Feature: Login to HRM Application


  Background:
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"

  @ValidCredentials @smoke
  Scenario: Login with valid credentials

    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login successfully and new page open
    Then user navigates to myinfo page
    Then user navigates to "Dashboard"





  @ValidCredentials @smoke
  Scenario: Login with valid credentials and navigate to myinfo page and verify records

    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login successfully and new page open
    Then user navigates to myinfo page
    Then user navigates to "Dashboard"
  Then user verify My Action




#  @InvalidCredentials
#  Scenario Outline: Login with invalid credentials
#
#    When User enters username as "<username>" and password as "<password>"
#    Then User should be able to see error message "<errorMessage>"
#
#    Examples:
#      | username   | password  | errorMessage                      |
#      | Admin      | admin12$$ | Invalid credentials               |
#      | admin$$    | admin123  | Invalid credentials               |
#      | abc123     | xyz$$     | Invalid credentials               |