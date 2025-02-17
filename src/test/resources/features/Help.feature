Feature: Validate Help Feature in OrangeHRM

  Background:
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"

  Scenario: User accesses the help page and returns to the home page

  Given User enters username as "testdata" from "login" in "1" with "Admiyrtyn" and password as "admin123"



    When user navigates to myinfo page
    And user clicks on the Help icon
    Then help page opens in a new tab displaying the relevant content
    And user verifies the content on the help page
    When user closes the help page and switches back to the home tab
#
#  Scenario: User accesses the help page and returns to the home page
#
#
#    Given User enters username as "Admin" and password as "admin123"
#    When user navigates to myinfo page
#    And user clicks on the Help icon
#    Then help page opens in a new tab displaying the relevant content
#    And user verifies the content on the help page
#    When user closes the help page and switches back to the home tab


#  Scenario: User accesses the help page and returns to the home page
#    Given User enters username as "Admiyrtyn" and password as "admin123"
#    When user navigates to myinfo page
#    And user clicks on the Help icon
#    Then help page opens in a new tab displaying the relevant content
#    And user verifies the content on the help page
#    When user closes the help page and switches back to the home tab

