Feature: Validate Recruitment Workflow in OrangeHRM

  Background:
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com/"

  Scenario: Verify job application process in Recruitment module
    Given User enters username as "Admin" and password as "admin123"
    When User navigates to the Recruitment page
    Then User validates the webpage URL for Recruitment
    And User selects a job position from the job listing
    And User applies to the selected job position:
      | FirstName           | Test             |
      | LastName            | Testing          |
      | Email               | abc@gmail.com    |