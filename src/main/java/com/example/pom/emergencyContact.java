
package com.example.pom;


import com.example.base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static com.example.base.driver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class emergencyContact extends base {

    @FindBy(xpath = "//span[normalize-space()='My Info']")
    private WebElement myInfoTab;

    @FindBy(xpath = "//a[text()='Emergency Contacts']")
    private WebElement emergencyContact;

    @FindBy(xpath = "//button[text()=' Add '][1]")
    private WebElement addContactButton;

    @FindBy(xpath = "//label[text()='Name'] //following::input[1]")
    private WebElement contactNameField;

    @FindBy(xpath = "//label[text()='Name'] //following::input[2]")
    private WebElement relationshipField;

    @FindBy(xpath = "//label[text()='Name'] //following::input[4]")
    private WebElement contactMobile;

    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement saveContactButton;


    public emergencyContact() {
        PageFactory.initElements(driver, this);
    }

    public void lanchbrowser() {
        setUp();
    }


    public void login(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//*[contains(@class, 'orangehrm-login-button')]")).click();
    }


    public void navigateToMyInfo() {
        myInfoTab.click();

    }


    public void addContact(String name, String relation, String mobile) {

//        emergencyContact.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
      wait.until(ExpectedConditions.visibilityOf(addContactButton));

        addContactButton.click();

       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Name'] //following::input[1]")));

        contactNameField.sendKeys(name);
        relationshipField.sendKeys(relation);
        contactMobile.sendKeys(mobile);

     //   WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Save ']")));
//
//        WebElement saveButton = driver.findElement(By.xpath("//button[text()=' Save ']"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Save ']")));
        saveContactButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Add '][1]")));
    }


    public void updateContactName(int recordNumber, String newName) throws InterruptedException {
        WebElement editButton = driver.findElement(By.xpath("(//i[@class='oxd-icon bi-pencil-fill'])[" + recordNumber + "]"));
        editButton.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Name'] //following::input[1]")));

//        contactNameField.clear();
//        Thread.sleep(500);
//        contactNameField.sendKeys(newName);
//        contactNameField.clearAndEnterText(newName);
//        contactNameField.sendKeys(Keys.CONTROL + "a"); // Select all text (Windows/Linux)
//        contactNameField.sendKeys(Keys.DELETE);       // Delete the selected text
//        Thread.sleep(500);                            // Allow time for the UI to update
//        contactNameField.sendKeys(newName);           // Enter the newname
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value='';", contactNameField); // Clear the field
//        Thread.sleep(500); // Optional: Allow UI to reflect the changes
//        contactNameField.sendKeys(newName); // Enter the new name

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value=''; arguments[0].dispatchEvent(new Event('input')); arguments[0].dispatchEvent(new Event('change'));", contactNameField);
//        Thread.sleep(500); // Optional: Allow UI to reflect the changes
//        contactNameField.sendKeys(newName); // Enter the new name
//

        Actions actions = new Actions(driver);
        actions.click(contactNameField)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(newName)
                .perform();

        //   WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Save ']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Save ']")));
        saveContactButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Add '][1]")));

        //   WebElement saveButton = driver.findElement(By.xpath("//button[text()=' Save ']"));
       // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);

    }


    public String getContactNameFromList(String newContactName) {
        WebElement contact = driver.findElement(By.xpath("//div[text()='" + newContactName + "']"));
        return contact.getText();
    }
}
