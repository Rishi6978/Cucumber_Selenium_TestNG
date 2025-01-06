@smoke
Feature: Update Employee Personal Details in OrangeHRM

  Background:
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"

  Scenario: Update employee personal information
    Given User enters username as "Admin" and password as "admin123"
    When user navigates to myinfo page
    And the user clicks on the PersonalDetails button and updates the personal details with:
      | FullName               | Surya             |
      | MiddleName             | Bhaskar           |
      | EmployeeId             | SB2791            |
      | OtherId                | 12345             |
      | Driver'sLicenseNumber  | 272727            |
      | Nationality            | Indian            |
      | MaritalStatus          | Married           |
      | Gender                 | Female            |