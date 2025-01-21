package com.example.definitions;

import com.example.base;
import com.example.pom.adminpage;
import com.example.pom.helppage;
import com.example.pom.homepage;
import com.example.pom.login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static com.example.base.driver;

public class Helpsteps {

    WebDriver driver;
    String mainWindowHandle;
    helppage hp;


    @Before
    public  void setUp() {

        base baseInstance = new base();
        //baseInstance.setUp(); // Initialize the WebDriver
        driver = base.driver;
        hp = new helppage(driver);

    }

    @Then("User clicks on help button")
    public void clickhelpbutton(){

        hp.clickonthehelpbutton();
        mainWindowHandle = driver.getWindowHandle();





    }

    @Then("User is navigated to a new window to perform some actions")
    public void userIsNavigatedToANewWindowToPerformSomeActions() {

        hp.switchToNewWindow();
        Assert.assertNotEquals(mainWindowHandle, driver.getWindowHandle());
        String newWindowTitle = driver.getTitle();
        //Assert.assertTrue(newWindowTitle.contains("Help"));

    }

    @Then("User closes the new window")
    public void userClosesTheNewWindow() {

        hp.closeNewWindowAndReturn(mainWindowHandle);


    }


    @Then("User returns to the original window")
    public void userReturnsToTheOriginalWindow() {

        Assert.assertTrue(hp.isOnDashboard());
    }

    @After
    public void teardown() {

        driver.quit();
    }
}
