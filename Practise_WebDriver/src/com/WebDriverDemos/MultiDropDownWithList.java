package com.WebDriverDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiDropDownWithList {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://register.rediff.com/register/register.php?FormName=user_details");

        WebElement day = driver.findElement(By.className("day"));
        WebElement month = driver.findElement(By.className("middle"));
        WebElement year = driver.findElement(By.className("year"));

        Select daySelect = new Select(day);
        Select monthSelect = new Select(month);
        Select yearSelect = new Select(year);

        // Use List to get all day options
        List<WebElement> dayOptions = daySelect.getOptions();
      //  System.out.println("Available Days:");
        
       for (WebElement option : dayOptions) {
            System.out.print(option.getText() + " ");
        }

     //   System.out.println("\n\nAvailable Months:");
            
        for (WebElement option : monthSelect.getOptions()) {
            System.out.print(option.getText() + " ");
      }

       // System.out.println("\n\nAvailable Years:");
        for (WebElement option : yearSelect.getOptions()) {
            System.out.print(option.getText() + " ");
      }

       
        daySelect.selectByVisibleText("16");
        monthSelect.selectByVisibleText("MAY");
        yearSelect.selectByVisibleText("1979");

        System.out.println("\n\nSelected Date: " +
            daySelect.getFirstSelectedOption().getText() + " " +
            monthSelect.getFirstSelectedOption().getText() + " " +
            yearSelect.getFirstSelectedOption().getText());

     /// not a viable solution as per i think.
    }
}
