package com.example.pom;

import com.example.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.PrivateKey;

//import static com.example.base.driver;

public class login extends base {


    @FindBy(xpath = "/*[@class='oxd-form']/div[3]/button")
    private WebElement btn_Login;



public void lanchbrowser(){
    setUp();

}


    public void logintoapp(String userName, String passWord) {

        // login to application
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(passWord);
        btn_Login.click();

        // go the next page
    }




}
