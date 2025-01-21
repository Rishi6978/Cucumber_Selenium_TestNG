package com.example.definitions;

import com.example.pom.claimspageobj;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.example.base.driver;

public class claimsstepdef {

    claimspageobj claimsPage = new claimspageobj();

  //  @Given("User enters username as {string} and password as {string}")
    //public void userEntersUsernameAndPassword(String username, String password) {
        // Assuming login logic is part of a LoginPageObj
       // LoginPageObj loginPage = new LoginPageObj();
       // loginPage.enterUsername(username);
       // loginPage.enterPassword(password);
        //loginPage.clickLogin();
   // }

  //  @When("User should be able to login successfully and new page open")
   // public void userLoginSuccessfully() {
     //   System.out.println("Login successful and new page opened.");
    //}

    @Then("user navigates to claims page")
    public void userNavigatesToClaimsPage() {
        claimsPage.navigateToClaimsPage();
    }

    //@And("fetch and print claims data")
    //public void fetchAndPrintClaimsData() {
       // claimsPage.printClaims();
    //}
}
