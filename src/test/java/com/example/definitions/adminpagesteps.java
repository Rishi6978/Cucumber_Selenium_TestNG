package com.example.definitions;

import com.example.pom.adminpage;
import com.example.pom.homepage;
import com.example.pom.login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static com.example.base.driver;

public class adminpagesteps {

    @Before
    public  void setUp() {

        login lg= new login();
        lg.lanchbrowser();

    }

    @Then("User navigates to admin page")
    public void navigatetoadminpage(){

        adminpage  adminpg = new adminpage();
        adminpg.navigatetoadminpage();

    }

    @Then("User clicks on add button")
    public void navigatetoaddbutton(){

        WebElement addButton = driver.findElement(By.xpath("//*[text()=' Add ']"));
        addButton.click();

    }

    @Then("User enters username as admin and checks for error")
    public void enterexsistingusername(){
        adminpage  adminpg = new adminpage();
        adminpg.enterduplicateusername();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        String errormssg = driver.findElement(By.xpath("//span[text()='Already exists']")).getText();

        Assert.assertEquals(errormssg, "Already exists");


    }




    @After
    public void teardown() {

        driver.quit();
    }

    @When("the user enters the password {string}")
    public void theUserEntersThePassword(String password) {
        adminpage  adminpg = new adminpage();
        adminpg.enterpassword(password);
    }

    @Then("the password strength indicator should display {string}")
    public void thePasswordStrengthIndicatorShouldDisplay(String strength) {
        adminpage adminpg = new adminpage();

        // Get the password strength message
        By strengthMessageLocator = adminpg.getPasswordStrengthMessage(strength);
        String actualMessage = driver.findElement(strengthMessageLocator).getText().trim(); // Trim spaces

//        // Log for debugging
//        System.out.println("Expected Strength: " + strength);
//        System.out.println("Actual Strength: " + actualMessage);

//        // Assert that the displayed strength matches the expected strength
//        Assert.assertEquals("Password strength message does not match!", strength, actualMessage);

        Assert.assertEquals(actualMessage, strength);
    }

    @Then("User clicks on the user role field and selects the Admin option")
    public void userClicksOnTheUserRoleFieldAndSelectsTheOption() {
        adminpage adminpg = new adminpage();
        String optionselected= adminpg.enteruserrole();
        System.out.print(optionselected);



    }

    @Then("User selects employee")
    public void userSelectsEmployee() {
        adminpage  adminpg = new adminpage();
        String empselected= adminpg.enteremployeename();
        System.out.print(empselected);

    }

    @Then("User selects the Enabled status")
    public void userSelectsTheEnabledStatus() {
        adminpage adminpg= new adminpage();
        adminpg.selectstatus();
    }

    @Then("User enters username")
    public void userEntersUsername() {
        adminpage adminpg= new adminpage();
        adminpg.enterusername();


    }

    @Then("User enters password and confirms it")
    public void userEntersPasswordAndConfirmsIt() {
        adminpage adminpg= new adminpage();
        adminpg.enterpass();
    }

    @Then("User clicks on save")
    public void userClicksOnSave() {
        adminpage adminpg= new adminpage();
        adminpg.clickonsave();
    }

    @Then("User verifies through toast message")
    public void userVerifiesThroughToastMessage() {
        adminpage adminpg= new adminpage();

        Assert.assertTrue(adminpg.toastmssgdisplayed());

    }
}
