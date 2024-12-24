package com.example.pom;

import com.example.base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PrivateKey;
import java.time.Duration;

//import static com.example.base.driver;

public class login extends base {


    @FindBy(xpath = "//*[@class='oxd-form']/div[3]/button")
    private WebElement btn_Login;

    @FindBy(css="h6.oxd-text")
    private WebElement Dashboard_heading;

    @FindBy(css="a[href=\"/web/index.php/pim/viewMyDetails\"]")
    private  WebElement MyInfoLink;
public login(){
    PageFactory.initElements(driver,this);
}


public void lanchbrowser(){
    setUp();

}


    public void logintoapp(String userName, String passWord) {

        // login to application
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(passWord);
        btn_Login.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(Dashboard_heading));
        MyInfoLink.click();


        // go the next page
    }




}
