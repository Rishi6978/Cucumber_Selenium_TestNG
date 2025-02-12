package com.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;

import static com.example.base.driver;

public class DashboardLinks {
    private final WebDriverWait wait; // Made final

    @FindBy(xpath = "//*[text()='Dashboard']/parent::span")
    public WebElement dashboardTitle;


    public DashboardLinks() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set timeout using Duration
        PageFactory.initElements(driver, this);
    }

    public void verifyDashboardIsDisplayed() {
        // Wait until the dashboard title is visible
        wait.until(ExpectedConditions.visibilityOf(dashboardTitle));

        Assert.assertTrue(dashboardTitle.isDisplayed(), "Dashboard title is not displayed.");
        String expectedText = "Dashboard";
        Assert.assertEquals(dashboardTitle.getText(), expectedText, "Dashboard title text does not match.");
    }

    public void verifyLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links found: " + links.size());
        for (WebElement ele : links) {
            String url = ele.getAttribute("href");
            if (url == null || url.isEmpty()) {
                System.out.println("Empty or null link found.");
                continue;
            }
            try {
                // Use URI instead of URL
                HttpURLConnection connection = (HttpURLConnection) new URI(url).toURL().openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                int responseCode = connection.getResponseCode();

                if (responseCode == 200) {
                    System.out.println("Valid link: " + url + " | Response code: " + responseCode);
                } else {
                    System.out.println("Broken link: " + url + " | Response code: " + responseCode);
                }
                connection.disconnect();
            } catch (URISyntaxException e) {
                System.out.println("Invalid URL syntax: " + url + " | Exception: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Exception while checking link: " + url + " | Exception: " + e.getMessage());
            }
        }
    }
}