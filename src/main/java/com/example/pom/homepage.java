package com.example.pom;

import com.example.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.example.base.driver;

public class homepage {

    @FindBy(xpath = "//*[text()='My Info']")
    private WebElement myInfo;

    @FindBy(xpath = "//div[@class='orangehrm-todo-list']")
    private List<WebElement> myActions;

    @FindBy(xpath = "//*[@class='oxd-icon-button']")
    private WebElement help;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement search_help;






    public homepage() {
        PageFactory.initElements(driver, this);
    }

public void navigatetosidemenu(){

        myInfo.click();



    System.out.println(driver.getCurrentUrl());

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='PIM']")));


}


    public void navigatetosidemenu(String menu){



        WebElement sidemenu = driver.findElement(By.xpath("//*[text()='" + menu + "']"));
        sidemenu.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='PIM']")));


    }


   public void myActions(){

myActions.get(0).click();

    }



    public void verifyTostmsg(){

        myActions.get(1).click();

    }



public void helpicon(){


        utils.click(help,"help icon");


             driver.getWindowHandles().forEach(tab-> driver.switchTo().window(tab));



    search_help.sendKeys("testing");

    driver.close();

    driver.getWindowHandles().forEach(tab-> driver.switchTo().window(tab));

    utils.click(help,"help icon");


}














//
//    public  void verify(){
//
//        utils.click(help,"click on help text");
//
//
//        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
//        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("test");
//
//        driver.close();
//        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
//
//
//    }
//


}
