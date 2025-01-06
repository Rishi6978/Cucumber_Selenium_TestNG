package com.example.definitions;

import com.example.pom.login;
import com.example.pom.myinfo;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;

import java.util.Map;

import static com.example.base.driver;

public class MyInfoPageDefinitions {
    @Before
    public void setUp() {
        login lg = new login();
        lg.lanchbrowser();
    }

    @And("the user clicks on the PersonalDetails button and updates the personal details with:")
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
        myInfoPage.updatePersonalDetails(fullName, middleName, employeeId, otherId, licenseNumber, licenseExpiryDate, dateOfBirth);
        myInfoPage.selectNationality(nationality);
        myInfoPage.selectMaritalStatus(maritalStatus);
        myInfoPage.selectGender(gender);
        System.out.println("Updated Personal Details: " + details);

    }
}