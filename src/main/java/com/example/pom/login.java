package com.example.pom;

import com.example.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.security.PrivateKey;

//import static com.example.base.driver;

public class login extends base {
 //  public login loginpg;

    @FindBy(xpath = "//*[@class='oxd-form']/div[3]/button")

    @FindBy(xpath = "//*[@class='oxd-form']/div[3]/button")
    private WebElement btn_Login;

    @FindBy(name = "username")
    private WebElement txt_username;



    @FindBy(xpath = "//div[@class='orangehrm-login-forgot']")
    private WebElement link_forgotpassword;


    public login() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css="h6.oxd-text")
    private WebElement Dashboard_heading;

    @FindBy(css="a[href=\"/web/index.php/pim/viewMyDetails\"]")
    private  WebElement MyInfoLink;

    @FindBy(xpath = "//div[@class='orangehrm-action-header']//button[contains(@class, 'oxd-button--text')]")
    private WebElement AddButton;

    @FindBy(xpath = "(//div[@class=\"oxd-form-row\"]//input[@class=\"oxd-input oxd-input--active\"])[1]")
    private WebElement Name;

    @FindBy(xpath = "(//div[@class=\"oxd-form-row\"]//input[@class=\"oxd-input oxd-input--active\"])[2]")
    private WebElement Relation;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveBTN;

    @FindBy(css="div[class=\"oxd-layout-context\"]")
    private By layOut;




public void lanchbrowser(){
    setUp();

}





public  void username(String UN)
{
    try {
        txt_username.sendKeys(UN);


    } catch (Exception e) {
        throw new RuntimeException(e);

    }
}


    public  void forgotpwd()
    {
        link_forgotpassword.click();
    }




    public void logintoapp(String userName, String passWord) {

        // login to application
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(passWord);
        btn_Login.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(Dashboard_heading));
        pageName("PIM");
        wait.until(ExpectedConditions.visibilityOfElementLocated(layOut));
        tabList("Emergency Contacts");
        AddButton.click();
        Name.sendKeys("KArthik");
        Relation.sendKeys("friend");
        saveBTN.click();



        // go the next page
    }




}
