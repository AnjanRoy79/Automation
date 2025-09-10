package com.OHRM.pages;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
    WebDriver driver;

    public AdminPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "ul.oxd-main-menu > li")List<WebElement> sideMenuOptions;
    @FindBy(xpath = "//span[text()='Admin']/parent::a")WebElement adminMenu;
    @FindBy(xpath = "//label[text()='Username']/../following-sibling::div/input")WebElement usernameInput;
    @FindBy(xpath = "//button[@type='submit']")WebElement searchBtn;
    @FindBy(xpath = "//button[@type='reset']")WebElement resetBtn;
    @FindBy(xpath = "//label[text()='User Role']/../following-sibling::div//div[@class='oxd-select-wrapper']")WebElement userRoleDropdown;
    @FindBy(xpath = "//label[text()='Status']/../following-sibling::div//div[@class='oxd-select-wrapper']")WebElement statusDropdown;
    @FindBy(css = ".oxd-table-row")List<WebElement> tableRows;
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")WebElement profileDropdown;
    @FindBy(xpath = "//a[text()='Logout']")WebElement logoutButton;
    
    
    // Test case 1 to count and display number of side menus
    public void validateMenuCount()
    {
        System.out.println("Menu Options Count: " + sideMenuOptions.size());
        for (WebElement option : sideMenuOptions) {
            System.out.println(option.getText());
        }
        adminMenu.click(); // clicking on admin link to perform the below tests
    }

    // Test case 2 to search by input of user name and display the results found in the search
    public void searchByUserName(String username)
    {
        usernameInput.sendKeys(username);
        searchBtn.click();
        System.out.println("Records Found (By Username): " + tableRows.size());
        resetBtn.click();
    }
    
    // Test case 3 to search by User role as admin and display the results found in the search
    public void searchByUserRole(String role) 
    {
        Select select = new Select(userRoleDropdown);
        select.selectByVisibleText(role);
        searchBtn.click();
        System.out.println("Records Found (By User Role): " + tableRows.size());
        resetBtn.click();
    }

    // Test case 4 to search by status either enabled/disabled and display the results found in the search
    public void searchByStatus(String status)
    {
        Select select = new Select(statusDropdown);
        select.selectByVisibleText(status);
        searchBtn.click();
        System.out.println("Records Found (By Status): " + tableRows.size());
        resetBtn.click();
    }
    
    public void logout()
    {
        profileDropdown.click();
        logoutButton.click();
    }
}

