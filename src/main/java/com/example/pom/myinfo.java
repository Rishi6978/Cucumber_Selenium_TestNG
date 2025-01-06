package com.example.pom;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class myinfo {
    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@name='middleName']")
    private WebElement middleNameField;

    @FindBy(xpath = "//label[text()='Employee Id']//following::input[1]")
    private WebElement employeeIdField;

    @FindBy(xpath =  "//label[text()='Other Id']//following::input[1]")
    private WebElement otherIdField;

    @FindBy(xpath =  "//label[text()='Other Id']//following::input[2]")
    private WebElement licenseNoField;

//    @FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[1]")
//    private WebElement licenseExpiryDateField;
//
//    @FindBy(xpath = "(//input[@placeholder='yyyy-dd-mm'])[2]")
//    private WebElement dateOfBirthField;

    private WebDriver driver;
    private WebDriverWait wait;

    public myinfo(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void updatePersonalDetails(String fullName, String middleName, String employeeId, String otherId, String licenseNumber, String licenseExpiryDate, String dateOfBirth) {
        /*wait.until(ExpectedConditions.elementToBeClickable(firstNameField)).clear();
        firstNameField.sendKeys(fullName);*/
        clearAndEnterText(firstNameField, fullName);
        clearAndEnterText(middleNameField, middleName);
        clearAndEnterText(employeeIdField, employeeId);
        clearAndEnterText(otherIdField, otherId);
        clearAndEnterText(licenseNoField, licenseNumber);
        // clearAndEnterText(licenseExpiryDateField, licenseExpiryDate);
        // clearAndEnterText(dateOfBirthField, dateOfBirth);
    }

    public void selectNationality(String nationality) {
//        WebElement nationalityOption = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[text()='" + nationality + "']")));
//        nationalityOption.click();

        WebElement dropdown = driver.findElement(By.xpath("//div[@class='oxd-select-text oxd-select-text--active'][1]")); // Replace with actual locator
        dropdown.click();
        // Locate the desired option and click it
        WebElement option = driver.findElement(By.xpath("//span[text()='" + nationality + "']")); // Update XPath
        option.click();
    }

    public void selectMaritalStatus(String maritalStatus) throws InterruptedException {
//        WebElement maritalStatusOption = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[text()='" + maritalStatus + "']")));
//        maritalStatusOption.click();

        Thread.sleep(5000);

        WebElement dropdown2 = driver.findElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active']//div[contains(@class, 'oxd-select-text')])[3]")); // Replace with actual locator
        dropdown2.click();
        // Locate the desired option and click it
        WebElement option2 = driver.findElement(By.xpath("//span[text()='" + maritalStatus + "']")); // Update XPath
        option2.click();
    }

    public void selectGender(String gender) {
      driver.findElement(By.xpath("//div[@class='--gender-grouped-field']//label[text()='" + gender + "']")).click();
    }

    private void clearAndEnterText(WebElement element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);

    }
    public void waitForElementToBeClickableAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-calendar-wrapper")));
        element.click();
    }

//    public void enterDateOfBirth(String dateOfBirth) {
//        WebElement dateOfBirthField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='yyyy-dd-mm']")));
//        waitForElementToBeClickableAndClick(dateOfBirthField);
//        dateOfBirthField.sendKeys(dateOfBirth);
//    }
//    public void enterLicenseExpiryDate(String licenseExpiryDate) {
//        WebElement licenseExpiryDateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='yyyy-dd-mm']"))); // Update the XPath if needed
//        waitForElementToBeClickableAndClick(licenseExpiryDateField);
//        licenseExpiryDateField.sendKeys(licenseExpiryDate);
//    }

}