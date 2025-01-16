package com.example.definitions;

import com.example.pom.EmergencyPageObj;
import com.example.pom.login;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import static com.example.base.driver;


public class Emegencystepdef {
    EmergencyPageObj eoj= new EmergencyPageObj();
        @And("user clicks on the Add button")
        public void userClicksOnTheAddButton() {
            EmergencyPageObj eoj= new EmergencyPageObj();
            eoj.addButton();
        }
        @And("user enters emergency contact details {string}, {string}, and {string}")
        public void userEntersEmergencyContactDetailsAnd(String name, String relationship, String telephone) throws InterruptedException {
            eoj.addEmergencyContact(name, relationship, telephone);
        }
        @And("user clicks on the save button")
        public void userClicksOnTheSaveButton() {
         eoj.clickSave();
        }
        @Then("emergency contact should be added successfully")
        public void emergencyContactShouldBeAddedSuccessfully() {
            System.out.println("Emergency contact added successfully!");
        }

    @And("user navigates to Emergency Contact Details")
    public void userNavigatesToEmergencyContactDetails() {
            eoj.navigateToEmergencyContact();
    }

    @And("user edits the second emergency contact name to {string}")
    public void userEditsTheSecondEmergencyContactNameTo(String newName) {

        eoj.editEmergencyContactName(0, newName);

    }

    @Then("user should see the updated name as {string}")
    public void userShouldSeeTheUpdatedNameAs(String arg0) {
System.out.println("hello");
    }
}

