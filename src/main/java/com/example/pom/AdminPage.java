package com.example.pom;

import com.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class AdminPage extends BasePage {

        @FindBy(xpath = "//div[contains(@class,'orangehrm-horizontal-padding')]/span")
        private WebElement recordsValue;

        @FindBy(xpath = "//button[contains(@class,'oxd-button--secondary') and contains(.,'Add')]")
        private WebElement addBtn;

        @FindBy(xpath = "//div[contains(text(),'AutoTest')]/parent::div/parent::div[@role='row']//child::i[@class='oxd-icon bi-trash']/parent::button[@type='button']")
        private WebElement deleteExistingUserRecord;

        @FindBy(xpath = "//div[contains(@class,'orangehrm-dialog-popup')]")
        private WebElement deletePopup;

        @FindBy(xpath = "//button[contains(@class,'oxd-button--medium oxd-button--label-danger')]")
        private WebElement deleteBtn;

        @FindBy(xpath = "//label[contains(text(),'User Role')]/parent::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//child::div[contains(@class,'oxd-select-text--active')]")
        private WebElement userRoleDropDownClk;

//        @FindBy(xpath = "//span[contains(text(),'Admin')]/parent::div[@role='option']")
//        private WebElement userRoleAsAdmin;

        @FindBy(xpath = "//div[contains(@class,'oxd-autocomplete-text-input oxd-autocomplete-text-input--')]/input")
        private WebElement employeeNameTextInput;

        @FindBy(xpath = "//label[contains(text(),'Status')]/parent::div[@class='oxd-input-group__label-wrapper']/following-sibling::div//child::div[contains(@class,'oxd-select-text--active')]")
        private WebElement statusDropDownClk;

//        @FindBy(xpath = "//span[contains(text(),'Enabled')]/parent::div[@role='option']")
//        private WebElement statusAsEnabled;

        @FindBy(xpath = "//label[contains(text(),'Username')]/parent::div/following-sibling::div/input[contains(@class,'oxd-input oxd-input')]")
        private WebElement userNameTextInput;

        @FindBy(xpath = "//label[contains(text(),'Password') and not(contains(text(),'Confirm Password'))]//parent::div/following-sibling::div/input[contains(@class,'oxd-input oxd-input')]")
        private WebElement passwordTextInput;

        @FindBy(xpath = "//label[contains(text(),'Confirm Password')]//parent::div/following-sibling::div/input[contains(@class,'oxd-input oxd-input')]")
        private WebElement confirmPasswordTextInput;

        @FindBy(xpath = "//button[@type='submit']")
        private WebElement saveBtn;


        public WebElement getUserRoleOption(String userRole) {
                return driver.findElement(By.xpath("//span[contains(text(),'"+userRole+"')]/parent::div[@role='option']"));
        }
        public WebElement getStatusOption(String status) {
                return driver.findElement(By.xpath("//span[contains(text(),'"+status+"')]/parent::div[@role='option']"));
        }
        public WebElement getEmployeeNameOption(String name){
                return driver.findElement(By.xpath( "//span[contains(text(),'"+name+"')]/parent::div[@role='option']"));
        }
        public WebElement getCheckuserName(String usrname){
                return driver.findElement(By.xpath( "//div[contains(text(),'"+usrname+"')]"));
        }

        public List<WebElement> getRecordsFound() {
                return driver.findElements(By.xpath("//div[contains(@class,'oxd-table-row--with-border')]"));
        }

        public AdminPage() {PageFactory.initElements(driver, this);}

        public String getInitalRecordsValues() {
                String getValue = recordsValue.getText();
                System.out.println(getValue);
                return getValue;
//                beforeAddingUserRecordsValue = Integer.parseInt(getValue.replaceAll("\\D+", ""));
//                System.out.println(beforeAddingUserRecordsValue);
        }


        public void DeleteRecord(){
                waitUntilElementDisplayed(addBtn);
                // Flag to indicate if the name is found
                boolean userNameFound = false;

                // Iterate through the list and check if the text contains the name
                for (WebElement element : getRecordsFound()) {
                        String elementText = element.getText();
                        if (elementText.contains("AutoTest")) {
                                userNameFound = true;
                                break;
                        }
                }

                // Print the result
                if (userNameFound) {
                        waitUntilElementDisplayed(deleteExistingUserRecord);
                        deleteExistingUserRecord.click();
                        waitUntilElementDisplayed(deletePopup);
                        deleteBtn.click();
                }
        }

        public void AddUser(){
                waitUntilElementDisplayed(addBtn);
                addBtn.click();
                waitUntilElementDisplayed(userRoleDropDownClk);
                userRoleDropDownClk.click();
                waitUntilElementDisplayed(getStatusOption("Admin"));
                getStatusOption("Admin").click();
                employeeNameTextInput.click();
                employeeNameTextInput.sendKeys("DHINA");
                waitUntilElementDisplayed(getEmployeeNameOption("DHINA"));
                getEmployeeNameOption("DHINA").click();
                statusDropDownClk.click();
                waitUntilElementDisplayed(getStatusOption("Enabled"));
                getStatusOption("Enabled").click();
                userNameTextInput.sendKeys("AutoTest");
                passwordTextInput.sendKeys("Test@123");
                confirmPasswordTextInput.sendKeys("Test@123");
                saveBtn.click();
                waitUntilElementDisplayed(addBtn);
        }

}
