package com.example.definitions;

import com.example.pom.EmergencyPageObj;
import com.example.pom.HelpObj;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Helpstepdef {
    HelpObj Hoj= new HelpObj();
    @And("user clicks on the Help icon")
    public void userClicksOnTheIcon() {
Hoj.clickHelpIcon();

    }

    @Then("help page opens in a new tab displaying the relevant content")
    public void helpPageOpensInANewTabDisplayingTheRelevantContent() {
        Hoj.windlowHandles();
Hoj.validateNewpageTitle();

    }

    @And("user verifies the content on the help page")
    public void userVerifiesTheContentOnTheHelpPage() {
Hoj.validateNewHelpPage();

    }

    @When("user closes the help page and switches back to the home tab")
    public void userClosesTheHelpPageAndSwitchesBackToTheHomeTab() {

Hoj.navigateToParentWindow();
    }

    @Then("user is successfully redirected to the home page")
    public void userIsSuccessfullyRedirectedToTheHomePage() {

Hoj.validateHomePage();
    }


}
