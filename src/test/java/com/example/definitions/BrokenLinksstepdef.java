package com.example.definitions;

import com.example.pom.BrokenLinks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BrokenLinksstepdef {

    @When("User navigates to the dashboard page and validates all the broken links present on the dashboard page")
    public void userNavigatesToTheDashboardPage() {
        BrokenLinks bl =new BrokenLinks();
        bl.verfiyTheDashboard();
    }

}
