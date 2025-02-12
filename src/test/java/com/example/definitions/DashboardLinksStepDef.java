package com.example.definitions;

import com.example.pom.DashboardLinks;
import io.cucumber.java.en.*;

public class DashboardLinksStepDef {

    private DashboardLinks dashboardLinks = new DashboardLinks();

    @When("User navigates to the dashboard page")
    public void userNavigatesToTheDashboardPage() {
        dashboardLinks.verifyDashboardIsDisplayed();
    }

    @Then("User verifies that all links on the dashboard are functional")
    public void userVerifiesAllLinksOnTheDashboard() {
        dashboardLinks.verifyLinks();
    }
}
