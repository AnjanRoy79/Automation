package com.Capstone.OHRM;



import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    WebDriver driver;

    @FindBy(xpath = "//span[text()='PIM']") WebElement pimTab;
    @FindBy(xpath = "//span[text()='My Info']") WebElement myInfoTab;
    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']") WebElement userDropdown;
    @FindBy(xpath = "//a[text()='Logout']") WebElement logoutLink;
    @FindBy(xpath = "//label[contains(text(),'Employee Id')]/parent::div/following-sibling::div/input") WebElement employeeIdField;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickPIM() {
        pimTab.click();
    }

    public void clickMyInfo() {
        myInfoTab.click();
    }

    public String getLoggedInUsername() {
        return userDropdown.getText();
    }

    public void logout() {
        userDropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }

    public String getEmployeeId() {
        return employeeIdField.getAttribute("value");
    }
}
	
