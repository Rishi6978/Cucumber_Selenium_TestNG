package com.example.pom;

import com.example.base;
import com.example.utils.ReadAndWriteExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
import java.security.PrivateKey;
import java.util.Map;
import java.util.Properties;
//import static com.example.base.driver;

public class login extends base {
    public static Map<String, String> data  = null;
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

    }
}


    public  void forgotpwd()
    {
        link_forgotpassword.click();
    }




    public void logintoapp(String FileName, String SheetName, String dataRowNum, String userName, String passWord) {


        String fileName2 =  FileName + ".xlsx";


        data = ReadAndWriteExcel.readExcelTabRowNew("./testdata/", fileName2, SheetName, dataRowNum);

        link_forgotpassword.isDisplayed();

       username(data.get("EmailId")+"2324");

       //driver.findElement(By.xpath("//*[text()='Zee']")).clck



        driver.findElement(By.name("password")).sendKeys(data.get("Password"));
        btn_Login.click();



    }




}
