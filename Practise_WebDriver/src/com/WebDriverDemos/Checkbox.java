package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://echoecho.com/htmlforms09.htm");

        String[] checkboxNames = { "option1", "option2", "option3" }; // putting into a array

        for (int i = 0; i < checkboxNames.length; i++) { 
        	// loop to check the values in array and put them in checkboxNames variable
        	 
            WebElement checkbox = driver.findElement(By.name(checkboxNames[i])); // checking the web element 

            if (!checkbox.isSelected()) { // checking if the web element is selected one by one from array and acts accordingly.
                checkbox.click();
            }


        }

       // driver.quit();
    }
}