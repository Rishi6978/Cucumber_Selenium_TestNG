Feature: Check and Print the claims in OrangeHRM


  Background:
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"
#scecnrio outline need line 17
  Scenario: Fetch and Print claims successfully
    Given User enters username as "Admin" and password as "admin123"
    When User should be able to login successfully and new page open
    Then user navigates to claims page
   # And user navigates to Emergency Contact Details
    #And user clicks on the Add button
   # And user enters emergency contact details "<name>", "<relationship>", and "<telephone>"
   # And user clicks on the save button
   # Then emergency contact should be added successfully
   # Examples:
    #  | name | relationship | telephone |