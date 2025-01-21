package com.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static com.example.base.driver;

public class ReadLinks {
    private WebDriverWait wait;

    @FindBy(xpath = "//*[text()='Dashboard']/parent::span")
    public WebElement dashboardTitle;
    @FindBy(xpath = "//*[text()='Dashboard']/parent::a")
    public WebElement DashboardSection;
    public ReadLinks() {
        PageFactory.initElements(driver, this);
    }
    public void verfiyTheDashboard(){
        Assert.assertTrue(dashboardTitle.isDisplayed(), "Dashboard title is not displayed.");
        String expectedText = "Dashboard";
        Assert.assertEquals(dashboardTitle.getText(), expectedText, "Dashboard title text does not match.");
        List<WebElement> links= driver.findElements(By.tagName("a"));
        System.out.println("Total links found: " + links.size());
        for (WebElement ele : links) {
            String url = ele.getAttribute("href");
            if (url == null || url.isEmpty()) {
                System.out.println("Empty or null link found.");
                continue;
            }
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                int responseCode = connection.getResponseCode();

                if (responseCode ==200) {
                    System.out.println("Valid link: " + url + " | Response code: " + responseCode);
                } else {
                    System.out.println("Read link: " + url + " | Response code: " + responseCode);
                }
                connection.disconnect();
            } catch (Exception e) {
                System.out.println("Exception while checking link: " + url + " | Exception: " + e.getMessage());
            }
        }
    }
}
