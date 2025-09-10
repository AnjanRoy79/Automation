package com.OHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")WebElement usernameInput;
    @FindBy(name = "password")WebElement passwordInput;
    @FindBy(xpath = "//button[@type='submit']")WebElement loginBtn;
    
    public void login(String username, String password) 
    {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
}
