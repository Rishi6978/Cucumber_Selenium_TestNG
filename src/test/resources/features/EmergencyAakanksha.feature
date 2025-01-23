Feature: Add Emergency Contact in OrangeHRM


  Background:
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"

  Scenario Outline: Add emergency contact details successfully
    Given User enters username as "Admin" and password as "admin123"
    When User should be able to login successfully and new page open
    Then user navigates to myinfo page
    And user navigates to Emergency Contact Details
    And user clicks on the Add button
    And user enters emergency contact details "<name>", "<relationship>", and "<telephone>"
    And user clicks on the save button
    Then emergency contact should be added successfully

    Examples:
      | name         | relationship | telephone |
      | John Smith   | Brother      | 1234567890  |
      | Aakanksha    | Sister       | 1234567891  |
      | Smith        | Father       | 1234567894 |


  Scenario: User edits the second emergency contact name and validates the updated name
    Given User enters username as "Admin" and password as "admin123"
    When User should be able to login successfully and new page open
    Then user navigates to myinfo page
    Given user navigates to Emergency Contact Details
    And user edits the second emergency contact name to "John Doe"
    Then user should see the updated name as "John Doe"