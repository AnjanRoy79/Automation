package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrangeHRMAdminClickTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            // 1. Go to OrangeHRM Demo
            driver.get("https://opensource-demo.orangehrmlive.com/");
            driver.manage().window().maximize();

            // 2. Login
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
            driver.findElement(By.name("password")).sendKeys("admin123");
            driver.findElement(By.xpath("//button[@type='submit']")).click();

            // 3. Wait for Dashboard
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));

            // 4. Locate Admin menu
            WebElement adminMenu = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']")
            ));

            // Optional: Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", adminMenu);
            Thread.sleep(1000);

            // 5. Try JavaScript click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", adminMenu);

            // Wait for Admin page to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='System Users']")));

            // 6. Confirm navigation
            String heading = driver.findElement(By.xpath("//h5")).getText();
            System.out.println("✅ Page heading after Admin click: " + heading);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
