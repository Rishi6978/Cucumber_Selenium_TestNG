package com.example.pom;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

import static com.example.base.driver;

public class myinfoattachment {
    public myinfoattachment() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()='My Info']")
    private WebElement myInfo;

    @FindBy(xpath = "//button[text()=' Add ']")
    private WebElement addbutton;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement fileadd;

    @FindBy(xpath = "(//button[text()=' Save '])[3]")
    private WebElement savebtn;

    @FindBy(xpath = "//p[text()='Successfully Saved']")
    private WebElement toastmssg;


    public void navigatetomyinfo() {

        myInfo.click();

    }

    public void clickadd() {

        addbutton.click();
    }

    public void addfile() {
        File uploadFile = new File("C://Users//likit//OneDrive//Desktop//TestFile.txt");


        fileadd.sendKeys(uploadFile.getAbsolutePath());
        savebtn.click();
    }

    public boolean verifyfilesave() {
        return toastmssg.isDisplayed();

    }


}
