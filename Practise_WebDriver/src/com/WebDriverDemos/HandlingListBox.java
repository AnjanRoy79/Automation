package com.WebDriverDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingListBox {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		
		//WebElement lstBox = driver.findElement(By.id("multiselect1"));
		//Select cars = new Select(lstBox);
		
		/// above two lines creating object and select class object to handle.
		
		Select cars = new Select (driver.findElement(By.id("multiselect1")));
		
		// above line is short cut as we will not use the WebElement Object anywhere in this program.
		List<WebElement>carlist = cars.getOptions();
		for(WebElement c : carlist) // putting all the WebElements in List and using for
			// loop printing the all the list of the list box
		System.out.println( c.getText()); 
		
		// check if the list box multiple values can be selected
		if(cars.isMultiple())
		{	cars.selectByVisibleText("Hyundai");
			cars.selectByIndex(1);
			cars.selectByValue("audix");
			// puting all the selected options in list to be printed
			List<WebElement> selectedCars = cars.getAllSelectedOptions();
			//System.out.println("Selected Cars");
			for(WebElement sc : selectedCars)
			System.out.println("Selected Car is"+  sc.getText());
			
			 cars.deselectByIndex(1);
	            System.out.println("After Deselecting :");
	            selectedCars = cars.getAllSelectedOptions();
	            for (WebElement sc : selectedCars)
	            {
	                System.out.println("Card deselected is :" + sc.getText());
			
			
		}
		

	}
driver.close();
}
	}
