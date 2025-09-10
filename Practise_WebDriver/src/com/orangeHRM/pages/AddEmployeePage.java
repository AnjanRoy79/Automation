package com.orangeHRM.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTest;
import utils.ScreenshotUtils;

public class AddEmployeePage {
    WebDriver driver;

    @FindBy(name = "firstName") WebElement firstName;
    @FindBy(name = "middleName") WebElement middleName;
    @FindBy(name = "lastName") WebElement lastName;

    @FindBy(xpath = "//span[contains(@class,'oxd-switch-input')]") WebElement createLoginCheckbox;

    @FindBy(xpath = "//label[text()='Username']/../following-sibling::div//input") WebElement newUsername;
    @FindBy(xpath = "//label[text()='Password']/../following-sibling::div//input") WebElement newPassword;
    @FindBy(xpath = "//label[text()='Confirm Password']/../following-sibling::div//input") WebElement confirmPassword;

    @FindBy(xpath = "//button[normalize-space()='Save']") WebElement saveButton;

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addEmployee(String fName, String mName, String lName, String newUname, String pwd) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(fName);
        middleName.sendKeys(mName);
        lastName.sendKeys(lName);
        logStep("Entered employee details: " + fName + " " + mName + " " + lName);

        createLoginCheckbox.click();
        wait.until(ExpectedConditions.visibilityOf(newUsername));
        newUsername.sendKeys(newUname);
        newPassword.sendKeys(pwd);
        confirmPassword.sendKeys(pwd);
        logStep("Entered login details for new employee: " + newUname);

        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
        logStep("Clicked Save button");
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
