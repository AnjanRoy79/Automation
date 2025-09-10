package com.assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import java.time.Duration;


public class Assignement20PractiseForm {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/automation-practice-form");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)", "");

        driver.findElement(By.id("firstName")).sendKeys("Anjan");
        driver.findElement(By.id("lastName")).sendKeys("Roy");
        driver.findElement(By.id("userEmail")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")).click();
        driver.findElement(By.id("userNumber")).sendKeys("1234567890");

        js.executeScript("window.scrollBy(0,100)", "");

        // Select Date of Birth
        // Below statement will select the dob field and ctrl+a will select the entire text
        
        driver.findElement(By.id("dateOfBirthInput")).sendKeys(Keys.CONTROL + "A");
        
        // Below statement will enter the desired dob and hit enter using key.enter method
        driver.findElement(By.id("dateOfBirthInput")).sendKeys("16 May 1979" + Keys.ENTER);

        js.executeScript("window.scrollBy(0,100)", "");

        // Subjects
        WebElement subjectBox = driver.findElement(By.id("subjectsInput"));
        subjectBox.sendKeys("Computer Science");
        subjectBox.sendKeys(Keys.ENTER);
        
       /// Alternative way of using the subject using the below statement
       
    	//driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]")).click();
    	//js.executeScript("window.scrollBy(0,100)", "");
		//driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]")).sendKeys("H");
		//driver.findElement(By.xpath("//*[@id=\"react-select-2-option-0\"]")).click();

        // Hobbies
        driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")).click();

        // Upload picture
        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\anjan.ray\\Desktop\\shiva\\ATT00031.jpg");
        js.executeScript("window.scrollBy(0,100)", "");

        // Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("test");

        js.executeScript("window.scrollBy(0,100)", "");

        
     // Click to open State dropdown and Select State
        driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]/div[1]")).click();
        js.executeScript("window.scrollBy(0,100)", "");
        driver.findElement(By.xpath("//*[@id=\"react-select-3-option-2\"]")).click();
        
     // Click to open State dropdown and Select city
        
        driver.findElement(By.xpath("//*[@id=\"city\"]/div/div[1]")).click();
        js.executeScript("window.scrollBy(0,100)", "");
        driver.findElement(By.xpath("//*[@id=\"react-select-4-option-1\"]")).click();
        
                // Submit form
      driver.findElement(By.id("submit")).click();
      driver.close();	

    }
}
