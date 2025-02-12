package com.example.pom;

import com.example.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardMyActions extends base {

    public DashboardMyActions() {
        PageFactory.initElements(driver, this);
    }

    // Method to return the list of action items
    public List<WebElement> getActionItems() {
        // Manually find elements using By
        By myActionsListLocator = By.xpath("//div[@class='orangehrm-todo-list-item']");
        return driver.findElements(myActionsListLocator); // Find elements directly
    }
}