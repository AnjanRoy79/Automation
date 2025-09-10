package com.WebDriverDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownList {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		WebElement drplst = driver.findElement(By.id("country"));
		Select countries = new Select(drplst); // select class is used for drop down handling
		System.out.println(countries.getFirstSelectedOption().getText()); // getText method of select class displays the name
		// getFirstSelectedOption fetches the first web element of drop down
		
		List<WebElement>list = countries.getOptions(); // putting all the countries using collection (list)
		System.out.println(list.size()); // prints the size of the list in int value
		
		for(WebElement L : list) // creating A reference variable to WebElement type using for loop
			System.out.println(L.getText()); // printing the entire list using getTest method
		
		///* If you want to perform any operation on the list then use List object
		/// * To perform any operation on actual drop down list then use Select object (Select class)

		//countries.selectByVisibleText("Germany");
		// selecting and changing the WebElement from drop down list by using visible text (Select class Object)
		
		countries.selectByValue("95");
		// selecting and changing the WebElement from drop down list by using value of the WebElement (Select class Object)
		System.out.println(countries.getFirstSelectedOption().getText());
		//printing the selected country
		
		
		driver.close();
	}

}
