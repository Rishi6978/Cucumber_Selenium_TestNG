package com.example.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import static com.example.base.driver;

public class Recruitment {
   // private WebDriver driver;
    private WebDriverWait wait;
    String parentWindow = driver.getWindowHandle();
    public Recruitment() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[text()='Recruitment']/parent::a")
    public WebElement recruitment;
    @FindBy(xpath = "//h6[text()='Recruitment']")
    public WebElement recruitmentTitle;
    @FindBy(xpath = "//*[text()='Vacancies']")
    public WebElement vacancies;
    @FindBy(xpath = "//*[text()=' Add ']")
    public WebElement addButton;
    @FindBy(xpath = "//*[text()=' Save ']")
    public WebElement saveButton;
    @FindBy(xpath = "//*[text()='Web Page URL : ']/following-sibling::a")
    public WebElement WebPageUrl;
    @FindBy(xpath = "//*[text()='test']/following-sibling::button")
    public WebElement jobApplyButton;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastName;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;
    @FindBy(xpath = "//*[text()='Browse']")
    public WebElement Browse;
    @FindBy(xpath = "//*[text()=' Submit ']")
    public WebElement submit;
    @FindBy(xpath = "//div[@role='document']")
    public WebElement successmsg;
    @FindBy(xpath = "//*[text()=' Ok ']")
    public WebElement Ok;

    public void clickOnRecruitment() throws InterruptedException {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(recruitment));
       // Thread.sleep(3000);
        recruitment.click();
        Assert.assertTrue(recruitmentTitle.isDisplayed(),"Recruitment title is not displayed landed on wrong page");
        String expectedText = "Recruitment";
        Assert.assertEquals(recruitmentTitle.getText(),expectedText, "Recruitment title text does not match.");
    }

    public void navigateToWebPageURl() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Assert.assertTrue(vacancies.isEnabled(),"Vacancies is not enabled");
        wait.until(ExpectedConditions.elementToBeClickable(vacancies));
        vacancies.click();
        Assert.assertTrue(addButton.isDisplayed(),"addbutton is not enabled");
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);
        wait.until(ExpectedConditions.elementToBeClickable(WebPageUrl));
        WebPageUrl.click();
    }

    public void navigateNewTabApplyJobs()
    {
       // HelpObj hp= new HelpObj(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(parentWindow)) {
                System.out.println("Window Handle: " + windowHandle);
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOf(jobApplyButton));
        jobApplyButton.click();
    }
    public void applyJobPosting(String firstname, String lastname, String mailid) throws InterruptedException, AWTException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.elementToBeClickable(firstName));
        myinfo info =new myinfo(driver);
        info.clearAndEnterText(firstName,firstname);
        info.clearAndEnterText(lastName,lastname);
        info.clearAndEnterText(email,mailid);
        Browse.click();
        StringSelection filePathSelection= new StringSelection("C:\\Users\\aakan\\Downloads\\Doc.rtf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection,null);
        Thread.sleep(4000);

        Robot rb=new Robot();
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
        submit.click();
        System.out.println(successmsg.getText());
        Ok.click();

        }
        public void closeTab()
        {
           driver.close();
           driver.switchTo().window(parentWindow);
        }

    }




