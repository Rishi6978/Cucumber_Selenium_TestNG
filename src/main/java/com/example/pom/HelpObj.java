package com.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class HelpObj {


    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//button[@title='Help']")
    public WebElement helpIcon;
    @FindBy(xpath = "//h6[text()='PIM']")
    public WebElement dashboard;

    public HelpObj(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    String parentWindow = driver.getWindowHandle();

    public void clickHelpIcon()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(helpIcon)).click();

    }
    public void windlowHandles()
    {

        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(parentWindow)) {
                System.out.println("Window Handle: " + windowHandle);
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
    public void validateNewpageTitle(){
        String helpPageTitle = driver.getCurrentUrl();
        System.out.println("Help Page Title: " + helpPageTitle);
        Assert.assertTrue(helpPageTitle.contains("help"));
    }

    public void validateNewHelpPage() {
        List<WebElement> Categories = driver.findElements(By.xpath("//span[@class='blocks-item-title']"));
        for (WebElement items : Categories) {

            System.out.println("Categories: " + items.getText().toString());
        }

    }
    public void navigateToParentWindow()
    {
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
