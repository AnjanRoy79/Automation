package com.assignment;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment13_RediffDOB {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		WebElement day = driver.findElement(By.className("day"));
		WebElement month = driver.findElement(By.className("middle"));
		WebElement year = driver.findElement(By.className("year"));
		
		Select dayselect = new Select(day);
		Select monthselect = new Select(month);
		Select yearselect = new Select(year);
		
		dayselect.selectByVisibleText("16");
		monthselect.selectByVisibleText("MAY");
		yearselect.selectByVisibleText("1979");
				
		System.out.println(dayselect.getFirstSelectedOption().getText() + " "
				+ monthselect.getFirstSelectedOption().getText() + " " +  yearselect.getFirstSelectedOption().getText());
		
	}

}
