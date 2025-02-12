package com.example.definitions;

import com.example.pom.DashboardMyActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static com.example.base.driver;

public class DashboardActionStepDef {

    DashboardMyActions action = new DashboardMyActions();

  //  @Before
  //  public void setUp() {
      //  login lg = new login();
      //  lg.logintoapp("Admin", "admin123");
   // }

   // @And("User should be on dashboard page")
    //public void verifyingDashboardPage() {
      //  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
   // }

    // This method is to match the step "the user is on the dashboard page"
    @Given("the user is on the dashboard page")
    public void userIsOnDashboardPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

    @When("the user checks the actions listed under My Actions")
    public void verifyActions() {
        Assert.assertFalse(action.getActionItems().isEmpty(), "My actions list is empty");
    }

    @Then("the user should see the following activities listed:")
    public void actionsList(DataTable dataTable) {
        List<String> activities = dataTable.asList();
        List<WebElement> actionItems = action.getActionItems();

        for (String activity : activities) {
            boolean found = actionItems.stream()
                    .anyMatch(item -> item.getText().equals(activity));
            Assert.assertTrue(found, "Activity not found: " + activity);
        }
    }

    //@After
   // public void teardown() {
       // driver.quit(); // Uncomment if you want to close the browser after tests
   // }
}