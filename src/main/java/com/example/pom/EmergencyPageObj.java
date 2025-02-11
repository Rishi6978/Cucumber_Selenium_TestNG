package com.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.example.base.driver;

public class EmergencyPageObj {


    private WebDriverWait wait;

    @FindBy(xpath = "//*[text()='Emergency Contacts']")
    private WebElement emergencyContactLink;
    @FindBy(xpath = "(//*[@type='button' and text()=' Add '])[1]")
    private WebElement addsectionButton;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement emergenyName;
    @FindBy(xpath = "//label[text()='Name'] //following::input[1]")
    private WebElement emergenyname;
    @FindBy(xpath = "//label[text()='Name'] //following::input[2]")
    private WebElement relationshipName;
    @FindBy(xpath = "//label[text()='Name'] //following::input[3]")
    private WebElement telephoneNumber;
    @FindBy(xpath = "(//*[@type='submit' and text()=' Save '])[1]")
    private WebElement save;


    public EmergencyPageObj() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToEmergencyContact() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(emergencyContactLink)).click();
    }

    public void addButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(addsectionButton)).click();
    }

    public void enterText(WebElement element, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    public void addEmergencyContact(String name, String relation, String phone) throws InterruptedException {
        enterText(emergenyName, name);
        Thread.sleep(5000);
        enterText(relationshipName, relation);
        enterText(telephoneNumber, phone);
    }

    public void clickSave() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(save)).click();
    }

    private List<WebElement> emergencyContactEditIcons() {
        return driver.findElements(By.xpath("//i[@class='oxd-icon bi-pencil-fill']"));
    }

    public void editEmergencyContactName(int index, String newName) {
        List<WebElement> contacts = emergencyContactEditIcons();

        if (contacts.size() > index) {
            contacts.get(index).click();
            //WebElement nameField = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
           // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          //  wait.until(ExpectedConditions.elementToBeClickable(emergenyName));
            Actions actions = new Actions(driver);
            actions.click(emergenyName).perform();

            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

            actions.sendKeys(Keys.DELETE).perform();
            //emergenyName.click();
            emergenyname.sendKeys(newName);
            save.click();
        } else {
            System.out.println("Error: No contacts found or index out of bounds");
        }

        System.out.println("new message1");
    }}