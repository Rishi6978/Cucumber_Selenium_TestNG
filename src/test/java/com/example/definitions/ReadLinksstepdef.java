package com.example.definitions;

import com.example.pom.ReadLinks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReadLinksstepdef {

    @When(value = "User navigates to the dashboard page and validates all the Read links present on the dashboard page")
    public void userNavigatesToTheDashboardPage() {
        ReadLinks bl =new ReadLinks();
        bl.verfiyTheDashboard();
    }

}
