package com.orangeHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseTest;
import utils.ScreenshotUtils;

public class LoginPage {
    WebDriver driver;

    @FindBy(name = "username") WebElement usernameInput;
    @FindBy(name = "password") WebElement passwordInput;
    @FindBy(xpath = "//button[@type='submit']") WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) throws InterruptedException {
        Thread.sleep(1000);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
        logStep("Logged in with username: " + username);
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
