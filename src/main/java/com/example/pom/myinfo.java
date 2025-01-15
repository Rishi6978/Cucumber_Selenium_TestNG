package com.example.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class myinfo {

    @FindBy(xpath = "//input[@name='firstName' and @placeholder='First Name']")
    public WebElement firstNameField;

    @FindBy(xpath = "//input[@name='middleName']")
    public WebElement middleNameField;

    @FindBy(xpath = "//label[text()='Employee Id']//following::input[1]")
    public WebElement employeeIdField;

    @FindBy(xpath = "//label[text()='Other Id']//following::input[1]")
    public WebElement otherIdField;

    @FindBy(xpath = "//label[text()='Other Id']//following::input[2]")
    public WebElement licenseNoField;

    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[1]")
    public WebElement userNameDropdownList;
    @FindBy(xpath = "//label[text()='Gender']")
    public WebElement gendertext;
    @FindBy(xpath = "//label[text()='Marital Status']")
    public WebElement MaritalStatusText;
    @FindBy(xpath = "//label[text()='Other Id']")
    public WebElement OtherIdText;
    @FindBy(xpath = "//*[text()=' Add ']//following-sibling::i")
    public WebElement AddAttachment;
    @FindBy(xpath = "(//*[@type='submit'])[3]")
    public WebElement saveAttachment;
    @FindBy(xpath = "//*[text()='Browse']")
    public WebElement Browse;
    @FindBy(xpath = "//div[@class='oxd-table-card']")
    public WebElement ListofAttchments;
    private WebDriver driver;
    private WebDriverWait wait;

    public myinfo(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void updatePersonalDetails(String fullName, String middleName, String employeeId, String otherId, String licenseNumber) {
        /*wait.until(ExpectedConditions.elementToBeClickable(firstNameField)).clear();
        firstNameField.sendKeys(fullName);*/
        clearAndEnterText(firstNameField, fullName);
        clearAndEnterText(middleNameField, middleName);
        clearAndEnterText(employeeIdField, employeeId);
        clearAndEnterText(otherIdField, otherId);
        clearAndEnterText(licenseNoField, licenseNumber);
        //clearAndEnterText(licenseExpiryDateField, licenseExpiryDate);
        //clearAndEnterText(dateOfBirthField, dateOfBirth);
    }

    public void selectNationality(String nationality) throws InterruptedException {
        Thread.sleep(5000);
        WebElement dropdown = driver.findElement(By.xpath("(//div[contains(@class, 'oxd-select-text') and contains(@class, 'oxd-select-text--active')])[1]"));
        String currentStatus = dropdown.getText().trim();

        if (currentStatus.equalsIgnoreCase(nationality)) {
            System.out.println("Marital status is already set to: " + nationality);
            return;
        }
        dropdown.click();

        List<WebElement> options = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//div[@role='listbox']//div[@class='oxd-select-option']")));
        // Loop through the options and select the matching nationality
        boolean isSelected = false;
        for (WebElement option : options) {
            String optionText = option.getText();
            if (optionText.equalsIgnoreCase(nationality)) {
                option.click();
                isSelected = true;
                break;
            }
        }
        if (!isSelected) {
            throw new NoSuchElementException("Nationality not found: " + nationality);
        }
    }

    public void selectMaritalStatus(String maritalStatus) throws InterruptedException {
        Thread.sleep(5000);
        WebElement dropdown1 = driver.findElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active']//div[contains(@class, 'oxd-select-text')])[3]"));
        String currentStatus = dropdown1.getText().trim();

        if (currentStatus.equalsIgnoreCase(maritalStatus)) {
            System.out.println("Marital status is already set to: " + maritalStatus);
            return;
        }
        dropdown1.click();

        List<WebElement> Maritaloptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//div[@class='oxd-select-option']")));

        boolean isSelected = false;
        for (WebElement Moption : Maritaloptions) {
            String optionText = Moption.getText();
            if (optionText.equalsIgnoreCase(maritalStatus)) {
                Moption.click();
                isSelected = true;
                break;
            }
        }
        if (!isSelected) {
            throw new NoSuchElementException("Maritalstatus not found: " + maritalStatus);
        }

    }

    public void selectGender(String gender) {
        WebElement genderOption = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@class='--gender-grouped-field']//label[text()='" + gender + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", genderOption);
        wait.until(ExpectedConditions.elementToBeClickable(genderOption));
    }

    public void clearAndEnterText(WebElement element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(driver);
        actions.click(element) // Focus on the element
                .keyDown(Keys.CONTROL)
                .sendKeys("a") // Select all text
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE) // Clear the text
                .perform();
        element.sendKeys(text);
    }

    public void waitForElementToBeClickableAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    // Method to enter the date of birth
    public void enterDateOfBirth(String dateOfBirth) {
        WebElement dateOfBirthField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Date of Birth']//following::input[1]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MaritalStatusText);
        waitForElementToBeClickableAndClick(dateOfBirthField);
        clearAndEnterText(dateOfBirthField, dateOfBirth);
        dateOfBirthField.sendKeys(Keys.TAB);
    }

    public void enterLicenseExpiry(String licenseExpiry) throws InterruptedException {
        WebElement licenseExpiryDateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='License Expiry Date']//following::input[1]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", OtherIdText);
        Thread.sleep(5000);
        waitForElementToBeClickableAndClick(licenseExpiryDateField);
        clearAndEnterText(licenseExpiryDateField, licenseExpiry);
        licenseExpiryDateField.sendKeys(Keys.TAB);
    }

    public void uploadFile() throws InterruptedException, AWTException {

    //    AddAttachment.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",AddAttachment );
        js.executeScript("arguments[0].click();", AddAttachment );
        Thread.sleep(2000);
        Browse.click();
        StringSelection filePathSelection= new StringSelection("C:\\Users\\aakan\\Downloads\\test.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection,null);
        Thread.sleep(4000);

        Robot rb=new Robot();
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
       //C:\Users\aakan\Downloads\test.png
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        saveAttachment.click();
Thread.sleep(2000);
        // js.executeScript("arguments[0].click();", Browse );
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='oxd-table-card']"));
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
    }

    public void save() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

    }


}
