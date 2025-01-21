package com.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.example.base.driver;

public class adminpage {

    public adminpage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()='Admin']")
    private WebElement adminPage;


    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active']")
    private WebElement usernametextfeild;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement confirmpasswordtextfeild;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordtextfeild;

    By strengthMessageLocator = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']/span");

    @FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[1]")
    private WebElement userroledropdown;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement usernamefield;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitbutton;

    @FindBy(xpath = "//div[@class='oxd-select-dropdown --positon-bottom']/div[@role='option'][2]")
    private WebElement enabledoption;

    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
    private WebElement statusdropdown;

    @FindBy(xpath = "//p[text()='Successfully Saved']")
    private WebElement toastmssg;







    public void navigatetoadminpage(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Admin']")));
        adminPage.click();

    }

    public void enterduplicateusername(){
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@class='oxd-input oxd-input--active']")));
        usernametextfeild.click();
        usernametextfeild.sendKeys("admin");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));




    }

    public void enterpassword(String password){
        passwordtextfeild.click();
        passwordtextfeild.sendKeys(password);


    }

    public By getPasswordStrengthMessage(String strength) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));

        // Locate the span element by matching normalized text
        By strengthMessageLocator = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']/span[normalize-space(text())='" + strength + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(strengthMessageLocator));

        return strengthMessageLocator;





    }

    public String enteruserrole(){
        userroledropdown.click();
        WebElement firstelement = driver.findElement(By.xpath("(//div[contains(@class, 'oxd-select-option')])[2]"));
        String optionselected= firstelement.getText();
        firstelement.click();
        return optionselected;
//        List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class, 'oxd-select-option')]"));
//
//        // Extract the text of each option
//        List<String> dropdownValues = new ArrayList<>();
//        for (WebElement option : options) {
//            dropdownValues.add(option.getText().trim());
//        }
//
//        // Return the list of dropdown values
//        return dropdownValues;



    }

    public String enteremployeename(){
        usernamefield.sendKeys("Lname");
        try {
            Thread.sleep(15000); // 15000 milliseconds = 15 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement firstemp = driver.findElement(By.xpath("//div[@role='listbox']/div[@role='option'][1]/span"));
        String empselected= firstemp.getText();
        firstemp.click();
        return empselected;





    }

    public void selectstatus(){

//        try {
//            Thread.sleep(15000); // 15000 milliseconds = 15 seconds
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        statusdropdown.click();
        try {
            Thread.sleep(15000); // 15000 milliseconds = 15 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        enabledoption.click();

    }

    public void enterusername(){

        usernametextfeild.click();
        usernametextfeild.sendKeys("admin1122");





    }

    public void enterpass(){

        passwordtextfeild.click();
        passwordtextfeild.sendKeys("password@12345");
        confirmpasswordtextfeild.click();
        confirmpasswordtextfeild.sendKeys("password@12345");


    }


    public void clickonsave() {
        submitbutton.click();

    }

    public boolean toastmssgdisplayed(){
        return toastmssg.isDisplayed();
    }
}

