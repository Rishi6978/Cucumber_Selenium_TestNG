package com.example.definitions;

import com.example.pom.RecruitmentAakanksha;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.*;
import java.util.Map;

public class Recruitmentstepdef {

    RecruitmentAakanksha recruitment= new RecruitmentAakanksha();

    @When("User navigates to the Recruitment page")
    public void userNavigatesToTheRecruitmentPage() throws InterruptedException {
        recruitment.clickOnRecruitment();

    }

    @Then("User validates the webpage URL for Recruitment")
    public void userValidatesTheWebpageURLForRecruitment() throws InterruptedException {
     //   String parentWindow = driver.getWindowHandle();

        recruitment.navigateToWebPageURl();

    }

    @And("User selects a job position from the job listing")
    public void userSelectsAJobPositionFromTheJobListing() {
        recruitment.navigateNewTabApplyJobs();
    }

    @And("User applies to the selected job position:")
    public void userAppliesToTheSelectedJobPosition(DataTable dataTable) throws InterruptedException, AWTException {
        Map<String, String> jobDetails = dataTable.asMap(String.class, String.class);
        String firstname = jobDetails.get("FirstName");
        String lastname = jobDetails.get("LastName");
        String mailid = jobDetails.get("Email");

        // Call the applyJobPosting method
        recruitment.applyJobPosting(firstname, lastname, mailid);
        System.out.println("Firstname:"+" "+firstname+"Lastname:"+" "+" "+lastname+"MailId:"+" "+mailid);
        recruitment.closeTab();

    }
}
