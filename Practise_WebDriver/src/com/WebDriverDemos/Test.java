package com.WebDriverDemos;



import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Step 1: Open the template listing page
        driver.get("https://www.jotform.com/form-templates/exam-registration-form");

        // Step 2: Click the "Use Template" button
        WebElement useTemplateBtn = driver.findElement(By.xpath("//button[contains(text(),'Use Template')]"));
        if (useTemplateBtn.isDisplayed()) {
            useTemplateBtn.click();
            System.out.println("Clicked on 'Use Template' button.");
        } else {
            System.out.println("'Use Template' button not visible.");
            driver.quit();
            return;
        }

        // Step 3: Switch to new tab
        Thread.sleep(3000); // Wait for the new tab to open
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // switch to new tab

        // Step 4: Wait and input data into the First Name field
        Thread.sleep(3000); // Let form load completely
        WebElement firstNameInput = driver.findElement(By.id("first_9"));

        if (firstNameInput.isDisplayed()) {
            firstNameInput.sendKeys("Anjan");
            System.out.println("Entered First Name.");
        } else {
            System.out.println("First Name field not visible.");
        }

        // Similarly you can fill Last Name, Email etc.
        WebElement lastNameInput = driver.findElement(By.id("last_9"));
        if (lastNameInput.isDisplayed()) {
            lastNameInput.sendKeys("Roy");
            System.out.println("Entered Last Name.");
        }

        WebElement emailInput = driver.findElement(By.id("input_10"));
        if (emailInput.isDisplayed()) {
            emailInput.sendKeys("anjan@example.com");
            System.out.println("Entered Email.");
        }

        // Add more fields here if needed...

        // Optional: Close after a delay
        Thread.sleep(5000);
        driver.quit();
    }
}
