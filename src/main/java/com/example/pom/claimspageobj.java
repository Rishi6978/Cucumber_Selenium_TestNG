package com.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.example.base.driver;

public class claimspageobj {

    private WebDriverWait wait;

    @FindBy(xpath = "//span[contains(@class, 'oxd-main-menu-item--name') and text()='Claim']")
    private WebElement claimsTab;

   // @FindBy(xpath = "//table[@id='claimsTable']")
    //private WebElement claimsTable;

    public claimspageobj() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    // Navigate to Claims Tab
    public void navigateToClaimsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(claimsTab)).click();
    }

    // Fetch and Print Claims
  //  public void printClaims() {
    //    wait.until(ExpectedConditions.visibilityOf(claimsTable));
      //  String claimsData = claimsTable.getText();
        //System.out.println("Claims Data:\n" + claimsData);
    //}
}