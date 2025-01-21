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
import java.util.Set;

import static com.example.base.driver;


public class helppage {

    private WebDriver driver;

    public helppage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@title='Help']")
    private WebElement helpbutton;
    @FindBy(xpath = "//*[@class='oxd-topbar-header-breadcrumb']/h6")
    private WebElement dashboardHeader;

    public void clickonthehelpbutton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Use driver instance
        wait.until(ExpectedConditions.elementToBeClickable(helpbutton));
        helpbutton.click();
    }

    public void switchToNewWindow() {
        String mainWindowHandle = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the new window to appear
        wait.until(driver -> driver.getWindowHandles().size() > 1);

        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public void closeNewWindowAndReturn(String mainWindowHandle) {
        driver.close();
        driver.switchTo().window(mainWindowHandle);
    }

    public boolean isOnDashboard() {
        return dashboardHeader.isDisplayed();

    }
}
