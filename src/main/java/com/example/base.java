package com.example;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class base {


    public static WebDriver driver;
    public final static int TIMEOUT = 30;

@Before
    public void setUp() {

    System.setProperty("webdriver.chrome.driver", "C:/Users/likit/OneDrive/Desktop/chromedriver.exe");


        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        //    options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));


    }


    @AfterAll
    public void closeAll(){
        if (driver != null) {
            driver.quit();
        }
    }
}
