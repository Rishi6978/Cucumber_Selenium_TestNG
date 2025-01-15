package com.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import static com.example.base.driver;

public class linksValidation {

    public linksValidation() {
        PageFactory.initElements(driver, this);
    }

    public void validateLinks() throws MalformedURLException {

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links found: " + links.size());

        for (WebElement link : links) {
            String url = link.getAttribute("href");

            if (url != null && !url.isEmpty()) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setRequestMethod("HEAD");
                    connection.connect();

                    int responseCode = connection.getResponseCode();
                    System.out.println("URL: " + url + " returned response code: " + responseCode);


                    Assert.assertEquals(responseCode, 200, "Invalid link: " + url);
                } catch (IOException e) {
                    System.err.println("Error validating URL: " + url);
                    e.printStackTrace();
                }
            } else {
                System.out.println("Invalid URL: " + url);
            }
        }
    }
}
