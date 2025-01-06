package com.example.definitions;


import com.example.pom.help;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HelpPageDefinitions {
    help hp= new help();

    @And("User clicks on the Help icon")
    public void userClicksOnTheHelpIcon() {
        hp.clickHelpButton();
    }

    @Then("new Tab opens with help information")
    public void newTabOpensWithHelpInformation() {
        hp.helpWindow();
    }

    @And("User validates information on the Help page")
    public void userValidatesInformationOnTheHelpPage() {
        hp.validateHelpPage();
    }

    @Then("User closes the help tab and returns to home page tab")
    public void userClosesTheHelpTabAndReturnsToHomePageTab() {
        hp.navigateToParentWindow();
        hp.validateHomePage();
    }
}