package com.OHRM.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;

public class AdminTest {

    WebDriver driver;

    @BeforeClass
    public void setup() 
    {
    	
    	//Below options used to avoid any notification/ pop from native browser
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-infobars");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        driver = new EdgeDriver(options); 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 1) // Login to page with valid credentials
    public void loginTest() 
    {
    	
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Test(priority = 2) // Counting and printing all the side menus
    public void verifyMenuCountAndClickAdmin() 
    {
    	
        List<WebElement> menuItems = driver.findElements(By.cssSelector("ul.oxd-main-menu > li"));
        System.out.println("Total Menu Items: " + menuItems.size());
        for (WebElement item : menuItems) {
            System.out.println(item.getText());
        }
        driver.findElement(By.xpath("//span[text()='Admin']/parent::a")).click();
    }

    @Test(priority = 3) // Searching by putting admin as user name and displaying the results
    public void searchByUserName()
    {
    	
        WebElement usernameInput = driver.findElement(By.xpath("//label[text()='Username']/../following-sibling::div/input"));
        usernameInput.sendKeys("Admin");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        List<WebElement> rows = driver.findElements(By.cssSelector(".oxd-table-row"));
        System.out.println("Records Found (By Username): " + rows.size());
        
         // Click Reset
        driver.findElement(By.xpath("//button[normalize-space()='Reset']")).click();
    }

    @Test(priority = 4) // Searching by user role as admin and displaying the results
    public void searchByUserRole() 
    {
    	
        // Open the dropdown
        driver.findElement(By.xpath("//label[text()='User Role']/../following-sibling::div//div[@class='oxd-select-wrapper']")).click();

        // Select "Admin" role
        driver.findElement(By.xpath("//div[@role='option']/span[text()='Admin']")).click();

        // Click Search
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        List<WebElement> rows = driver.findElements(By.cssSelector(".oxd-table-row"));
        System.out.println("Records Found (By User Role): " + rows.size());

        // Click Reset
        driver.findElement(By.xpath("//button[normalize-space()='Reset']")).click();
    }


    @Test(priority = 5) // Searching by user status as enabled/disabled and displaying the results
    public void searchByStatus()
    {
    	
        // Open the Status dropdown
        driver.findElement(By.xpath("//label[text()='Status']/../following-sibling::div//div[@class='oxd-select-wrapper']")).click();

        // Select "Enabled" status
        driver.findElement(By.xpath("//div[@role='option']/span[text()='Enabled']")).click();

        // Click Search
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        List<WebElement> rows = driver.findElements(By.cssSelector(".oxd-table-row"));
        System.out.println("Records Found (By Status): " + rows.size());
    }
    
    @Test(priority = 6) // Logout after performing all the above tests
    public void logout() 
    {
    	driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
    	driver.findElement(By.xpath("//a[text()='Logout']")).click();
    	
    }
    
    @AfterClass
    public void Close() 
    {
        driver.close();
    }
}