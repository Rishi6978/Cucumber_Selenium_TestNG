package com.example.pom;

import com.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.security.PrivateKey;

//import static com.example.base.driver;

public class login extends BasePage {
 //  public login loginpg;

    @FindBy(xpath = "//*[@class='oxd-form']/div[3]/button")
    private WebElement btn_Login;

    @FindBy(name = "username")
    private WebElement txt_username;



    @FindBy(xpath = "//div[@class='orangehrm-login-forgot']")
    private WebElement link_forgotpassword;


    public login() {
        PageFactory.initElements(driver, this);
    }


public void lanchbrowser(){
    setUp();

}





public  void username(String UN)
{
    try {
        txt_username.sendKeys(UN);


    } catch (Exception e) {
        throw new RuntimeException(e);
        //Assert.fail();
       // SS();
    }
}


    public  void forgotpwd()
    {
        link_forgotpassword.click();
    }




    public void logintoapp(String userName, String passWord) {

       // login lg = new login();

        // login to application

        link_forgotpassword.isDisplayed();

       username(userName);

        driver.findElement(By.name("password")).sendKeys(passWord);
        btn_Login.click();

        // go the next page
    }




}
