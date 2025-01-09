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
      | LicenseExpiryDate     | 2024-02-02    |
      | Nationality           | Austrian       |
      | MaritalStatus         | Single          |
      | DateofBirth           | 2024-01-01      |
      | Gender                | Male            |
    And User save the record
    Then User uploads a file
