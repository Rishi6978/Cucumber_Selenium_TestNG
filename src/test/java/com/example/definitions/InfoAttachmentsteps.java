package com.example.definitions;

import com.example.pom.login;
import com.example.pom.myinfoattachment;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.example.base.driver;

public class InfoAttachmentsteps {

    @Before
    public  void setUp() {

        login lg= new login();
        lg.lanchbrowser();

    }

    @Then("User navigates to MyInfo page")
    public void userNavigatesToMyInfoPage() {
        myinfoattachment mi= new myinfoattachment();
        mi.navigatetomyinfo();
        
    }

    @Then("User clicks on add button for attachments")
    public void userClicksOnAddButtonForAttachments() {
        myinfoattachment mi= new myinfoattachment();
        mi.clickadd();

    }

    @After
    public void teardown() {

        driver.quit();
    }

    @Then("User attaches a file and clicks on save button")
    public void userAttachesAFileAndClicksOnSaveButton() {
        myinfoattachment mi= new myinfoattachment();
        mi.addfile();
    }

    @Then("User verifies the attachment is saved")
    public void userVerifiesTheAttachmentIsSaved() {
        myinfoattachment mi= new myinfoattachment();
        Assert.assertTrue(mi.verifyfilesave());



    }
}
