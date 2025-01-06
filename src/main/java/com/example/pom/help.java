package com.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static com.example.base.driver;

public class help {

    private WebDriverWait wait;

    @FindBy(xpath = "//button[@title='Help']")
    public WebElement helpbutton;
    @FindBy(xpath = "//h6[text()='Dashboard']")
    public WebElement dashboard;

    String parentWindow;

    public help() {
        PageFactory.initElements(driver, this);
    }

    public void clickHelpButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(helpbutton)).click();
    }

    public void helpWindow() {
        Set<String> windowHandles = driver.getWindowHandles();

        Iterator<String> iterator = windowHandles.iterator();
        parentWindow = iterator.next();
        String childWindow = iterator.next();

        driver.switchTo().window(childWindow);
    }

    public void validateHelpPage(){
        String helpPageTitle = driver.getCurrentUrl();
        System.out.println("Help Page Title: " + helpPageTitle);
        Assert.assertTrue(helpPageTitle.contains("help"));

        List<WebElement> Categories = driver.findElements(By.xpath("//span[@class='blocks-item-title']"));
        for (WebElement items : Categories) {
            System.out.println("Categories: " + items.getText().toString());
        }
    }

    public void navigateToParentWindow() {
        driver.close();
        driver.switchTo().window(parentWindow);
    }

    public void validateHomePage()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(dashboard));

        System.out.println(dashboard.getText());


    }




}