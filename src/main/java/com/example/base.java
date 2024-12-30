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
    public WebDriver setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //    options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
return driver;

    }


   /* @AfterAll
    public void closeAll()
    {
driver.quit();
    }*/
}
