package com.example.definitions;

import com.example.pom.linksValidation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

public class LinksValidationDefinitions {
    linksValidation lv = new linksValidation();

    @And("User captures and validates all links on the Dashboard page")
    public void userCapturesAndValidatesAllLinksOnTheDashboardPage() throws MalformedURLException {
        lv.validateLinks();
    }
}
