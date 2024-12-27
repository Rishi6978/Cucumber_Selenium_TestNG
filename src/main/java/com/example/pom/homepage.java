package com.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static com.example.base.driver;

public class homepage {

    @FindBy(xpath = "//*[text()='My Info']")
    private WebElement myInfo;

    @FindBy(xpath = "//div[@class='orangehrm-todo-list']")
    private List<WebElement> myActions;


    public homepage() {
        PageFactory.initElements(driver, this);
    }

    public void navigatetosidemenu() {

        myInfo.click();

        System.out.println(driver.getCurrentUrl());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='PIM']")));

    }

    public void navigatetosidemenu(String menu) {

        // myInfo.click();
        WebElement sidemenu = driver.findElement(By.xpath("//*[text()='" + menu + "']"));
        sidemenu.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='PIM']")));
    }

    public void myActions() {
        myActions.get(0).click();
    }


}
