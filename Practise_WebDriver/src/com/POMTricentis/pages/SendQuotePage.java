package com.POMTricentis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendQuotePage {
    WebDriver driver;

    @FindBy(id = "email")WebElement email;
    @FindBy(id = "phone")WebElement phone;
    @FindBy(id = "username")WebElement username;
    @FindBy(id = "password")WebElement password;
    @FindBy(id = "confirmpassword")WebElement confirmPassword;
    @FindBy(id = "Comments")WebElement comments;
    @FindBy(id = "sendemail")WebElement sendButton;
    
    public SendQuotePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendQuote(String emailId, String phoneNum, String uname, String pwd, String comment) throws InterruptedException {
        email.sendKeys(emailId);
        phone.sendKeys(phoneNum);
        username.sendKeys(uname);
        password.sendKeys(pwd);
        confirmPassword.sendKeys(pwd);
        comments.sendKeys(comment);
        sendButton.click();
        Thread.sleep(3000); // wait for confirmation
        
    }
}
