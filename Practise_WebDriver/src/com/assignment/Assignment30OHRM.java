package com.assignment;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Assignment30OHRM {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		// Login with Admin 
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		// Click on PIM
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")).click();
		
		// Click on + Add button
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
		
		// Add First name, middle name, last name
		
		driver.findElement(By.name("firstName")).sendKeys("Anjan");
		driver.findElement(By.name("middleName")).sendKeys("Kumar");
		driver.findElement(By.name("lastName")).sendKeys("Roy");
		
		// Click on create login detail
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form"
				+ "/div[1]/div[2]/div[2]/div/label/span")).click();
		
		// Enter user name/ password/ confirm password and click save button
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]"
				+ "/div[3]/div/div[1]/div/div[2]/input")).sendKeys("AnjanTest123");
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div"
				+ "[1]/div[2]/div[4]/div/div[1]/div/div[2]/input")).sendKeys("Zxcv@786b");
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]"
				+ "/div[2]/div[4]/div/div[2]/div/div[2]/input")).sendKeys("Zxcv@786b");
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[contains(@class,'bi-caret-down-fill')]"))).click();
        Thread.sleep(5000);
        // Logout
        
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout"))).click();
        
        
    	Thread.sleep(5000);
    	
    	// Entering the newly created user name and password and printing the user name.
        
		driver.findElement(By.name("username")).sendKeys("AnjanTest123");
		driver.findElement(By.name("password")).sendKeys("Zxcv@786b");
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		WebElement name = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p"));
		String value1 = name.getText();
		System.out.println("Logged in user " + value1);
		
Thread.sleep(5000);

// clicking on my info link

driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a/span")).click();

// printing the employee id

WebElement employeeIdInput = driver.findElement(By.xpath("//label[contains(text(),'Employee Id')]/parent::div/following-sibling::div/input"));
WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form"
		+ "/div[2]/div[1]/div[1]/div/div[2]/input")));
String empId = employeeIdInput.getAttribute("value");
System.out.println("Employee ID: " + empId);

//logout again after printing in console

WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[contains(@class,'bi-caret-down-fill')]"))).click();
wait2.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout"))).click();

//login with admin again

driver.findElement(By.name("username")).sendKeys("Admin");
driver.findElement(By.name("password")).sendKeys("admin123");
driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

Thread.sleep(5000);

//Search and delete

driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/input")).sendKeys("AnjanTest123\r\n"
		+ "");
          
		
	}

}


