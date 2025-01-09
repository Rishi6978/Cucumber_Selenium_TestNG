package com.example.definitions;

import com.example.pom.myinfo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.awt.*;
import java.util.Map;

import static com.example.base.driver;

public class myinfostepdef {
    @Then("the user clicks on the PersonalDetails button and updates the personal details with:")
    public void ClicksOnThePersonalDetails(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        Map<String,String> details = dataTable.asMap(String.class, String.class);
        String fullName = details.get("FullName");
        String middleName = details.get("MiddleName");
        String employeeId = details.get("EmployeeId");
        String otherId = details.get("OtherId");
        String licenseNumber = details.get("Driver'sLicenseNumber");
        String licenseExpiryDate = details.get("LicenseExpiryDate");
        String nationality = details.get("Nationality");
        String maritalStatus = details.get("MaritalStatus");
        String dateOfBirth = details.get("DateofBirth");
        String gender = details.get("Gender");
        myinfo myInfoPage = new myinfo(driver);
        myInfoPage.updatePersonalDetails(fullName, middleName, employeeId, otherId, licenseNumber);
        myInfoPage.selectNationality(nationality);
        myInfoPage.selectMaritalStatus(maritalStatus);
        myInfoPage.selectGender(gender);
        myInfoPage.enterDateOfBirth(dateOfBirth);
        myInfoPage.enterLicenseExpiry(licenseExpiryDate);
        System.out.println("Updated Personal Details: " + details);
       // Assert.assertEquals(myInfoPage.firstNameField.getAttribute("value"), fullName, "Full Name not updated correctly!");
        Assert.assertEquals(myInfoPage.middleNameField.getAttribute("value"), middleName, "Middle Name not updated correctly!");
        Assert.assertEquals(myInfoPage.employeeIdField.getAttribute("value"), employeeId, "Employee ID not updated correctly!");
        Assert.assertEquals(myInfoPage.otherIdField.getAttribute("value"), otherId, "Other ID not updated correctly!");
        Assert.assertEquals(myInfoPage.licenseNoField.getAttribute("value"), licenseNumber, "License Number not updated correctly!");
    }
    @And("User uploads a file")
    public void userUploadsAFile() throws InterruptedException, AWTException {
        myinfo myInfoPage = new myinfo(driver);

        myInfoPage.uploadFile();


    }

    @Then("User save the record")
    public void userSaveTheRecord() throws InterruptedException {
        myinfo myInfoPage = new myinfo(driver);
        myInfoPage.save();
    }


}
