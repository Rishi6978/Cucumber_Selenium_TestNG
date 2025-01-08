package com.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.example.base.driver;

public class utils {


    /**
     * Method to click on element  using selenium
     *
     * @param element     = webElement
     * @param elementName = Name of the element to  display in the report
     */
    public static void click(WebElement element, String elementName) {
        try {

            element.click();



            System.out.println(elementName);

        } catch (Exception exception) {
            exception.printStackTrace();
            Assert.fail(exception.getMessage());

        }
    }

}
