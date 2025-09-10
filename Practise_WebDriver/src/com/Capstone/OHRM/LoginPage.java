package com.Capstone.OHRM;



import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

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
    }
}

