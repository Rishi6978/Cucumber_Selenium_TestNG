Feature: Update Employee Personal Details in OrangeHRM

  Background:
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"

  Scenario: Update employee personal information
    Given User enters username as "Admin" and password as "admin123"
    When user navigates to myinfo page
    Then the user clicks on the PersonalDetails button and updates the personal details with:
      | FullName            | Test             |
      | MiddleName          | Testing          |
      | EmployeeId          | muser0087        |
      | OtherId             | 4957589          |
      | Driver'sLicenseNumber | 56788          |
      | LicenseExpiryDate     | 13-02-2024     |
      | Nationality           | Austrian       |
      | MaritalStatus         | Single          |
      | DateofBirth           | 24-01-2024      |
      | Gender                | Male            |
    And User save the record