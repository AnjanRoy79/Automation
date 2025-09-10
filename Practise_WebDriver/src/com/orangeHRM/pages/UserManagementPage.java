package com.orangeHRM.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import utils.BaseTest;
import utils.ScreenshotUtils;

import java.time.Duration;
import java.util.List;

public class UserManagementPage {
    WebDriver driver;

    @FindBy(xpath = "//span[text()='Admin']") WebElement adminTab;
    @FindBy(xpath = "//span[text()='PIM']") WebElement pimTab;

    @FindBy(xpath = "//label[text()='Username']/following::input[1]") WebElement adminUsernameField;
    @FindBy(xpath = "//button[normalize-space()='Search']") WebElement adminSearchButton;

    @FindBy(xpath = "//button[normalize-space()='Add']") WebElement addButton;
    @FindBy(xpath = "//a[contains(@href,'viewEmployeeList')]") WebElement employeeListLink;

    @FindBy(xpath = "//div[@role='rowgroup']//div[@role='row']") List<WebElement> searchResults;
    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']") WebElement deleteIcon;
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']") WebElement confirmDeleteButton;

    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToAdminTab() {
        adminTab.click();
        logStep("Clicked Admin Tab");
    }

    public void goToPIMTab() {
        pimTab.click();
        logStep("Clicked PIM Tab");
    }

    public void clickAddButton() {
        addButton.click();
        logStep("Clicked Add Button");
    }

    public void openEmployeeList() {
        employeeListLink.click();
        logStep("Opened Employee List");
    }

    public void searchUser(String username) throws InterruptedException {
        adminUsernameField.clear();
        adminUsernameField.sendKeys(username);
        adminSearchButton.click();
        Thread.sleep(3000);
        logStep("Searched for user: " + username);
    }

    public void deleteSearch() {
        if (!searchResults.isEmpty()) {
            searchResults.get(0).click();
            deleteIcon.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton)).click();
            logStep("Deleted searched user");
        } else {
            BaseTest.getTest().info("No record found to delete.");
        }
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
