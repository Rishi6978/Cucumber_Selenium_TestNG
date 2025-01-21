Feature: Admin Tab vrifications


  Background:
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"


  Scenario: Creating new role for employee

    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login successfully and new page open
    Then User navigates to admin page
    Then User clicks on add button
    Then User enters username as admin and checks for error

  Scenario Outline: Creating new role for employee with different password lengths

    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login successfully and new page open
    Then User navigates to admin page
    Then User clicks on add button
    When the user enters the password "<password>"
    Then the password strength indicator should display "<strength>"

    Examples:
      | password     | strength  |
      | 123          | Very Weak |
      | abc1        | Weak     |
      | Likitha      | Better    |
      | Likitha@1    | Strong    |
      | Likitha@1234 | Strongest |

  Scenario: Creating new role for employee

    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login successfully and new page open
    Then User navigates to admin page
    Then User clicks on add button
    Then User clicks on the user role field and selects the Admin option
    Then User selects employee
    Then User selects the Enabled status
    Then User enters username
    Then User enters password and confirms it
    Then User clicks on save
    Then User verifies through toast message

