package com.orangeHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTest;
import utils.ScreenshotUtils;

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
        logStep("Clicked PIM Tab");
    }

    public void clickMyInfo() {
        myInfoTab.click();
        logStep("Clicked My Info Tab");
    }

    public String getLoggedInUsername() {
        String username = userDropdown.getText();
        logStep("Logged in user: " + username);
        return username;
    }

    public void logout() {
        userDropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
        logStep("Logged out of application");
    }

    public String getEmployeeId() {
        String empId = employeeIdField.getAttribute("value");
        logStep("Fetched Employee ID: " + empId);
        return empId;
    }

    private void logStep(String message) {
        String screenshotPath = ScreenshotUtils.captureScreenshot(driver, message.replace(" ", "_"));
        try {
            BaseTest.getTest().pass(message).addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
