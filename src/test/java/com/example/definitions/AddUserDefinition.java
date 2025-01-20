package com.example.definitions;

import com.example.pom.AdminPage;
import com.example.pom.homepage;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import static com.example.PageFunctions.waitfor;

public class AddUserDefinition {

    private static final Logger log = LoggerFactory.getLogger(AddUserDefinition.class);
    int beforeAddingUserRecordsValue;
    int afterAddingUserRecordsValue;

    @Then("Add User to Admin User Management")
    public void addUserToUserManagement() {

        AdminPage adminPage = new AdminPage();
        adminPage.DeleteRecord();
        waitfor(5);
        beforeAddingUserRecordsValue = Integer.parseInt((adminPage.getInitalRecordsValues()).replaceAll("\\D+", ""));
        System.out.println(beforeAddingUserRecordsValue);
        adminPage.AddUser();
        waitfor(5);
        afterAddingUserRecordsValue = Integer.parseInt(adminPage.getInitalRecordsValues().replaceAll("\\D+", ""));
        System.out.println(afterAddingUserRecordsValue);

        //Verify
        Assert.assertNotEquals(beforeAddingUserRecordsValue, afterAddingUserRecordsValue);
    }
}
