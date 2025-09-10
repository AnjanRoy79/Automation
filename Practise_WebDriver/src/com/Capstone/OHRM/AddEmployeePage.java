package com.Capstone.OHRM;



import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

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

        // Wait for first name field to be visible
        wait.until(ExpectedConditions.visibilityOf(firstName));

        // Filling in the name fields
        firstName.sendKeys(fName);
        middleName.sendKeys(mName);
        lastName.sendKeys(lName);

        // Enabling login details
        createLoginCheckbox.click();

        // Wait for login fields to be visible
        wait.until(ExpectedConditions.visibilityOf(newUsername));
        newUsername.sendKeys(newUname);
        newPassword.sendKeys(pwd);
        confirmPassword.sendKeys(pwd);

        // Clicking on save button
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
}

