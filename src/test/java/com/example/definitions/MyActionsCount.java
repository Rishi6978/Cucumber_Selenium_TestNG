package com.example.definitions;

import com.example.pom.MyActions;
import com.example.pom.login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.example.base.driver;


public class MyActionsCount {

    @Before
    public  void setUp() {

        login lg= new login();
        lg.logintoapp("Admin","admin123");
    }
MyActions action = new MyActions();
@And("User should be on dashboard page")
    public void verifyingDashboardPage(){

    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

}

@When("User checks the actions listed under My Actions")
    public void  verifyActions(){
    Assert.assertTrue(!action.getActionItems().isEmpty(), "My actions list is not empty");
}

@Then("User should see 2 actions listed")
    public void actionsCount(){
    int actionsCount = action.getActionItems().size();
    Assert.assertEquals(actionsCount,2);
}
    @After
    public void teardown() {

        //    driver.quit();
    }
}
