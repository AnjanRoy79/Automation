package com.assignment;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment21_rediff {

	public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.rediff.com/");
        
        // clicking on money link and money gainers link 
        
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div[5]/div[1]/span[7]/a")).click();
        
        // To scroll down the page 
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        
        // To print the headers of the table
        
		List<WebElement> headers = driver.findElements(By.xpath("/html/body/div[6]/div[1]/table/thead/tr/th"));
		for(WebElement h : headers)
			System.out.println(h.getText());
		
		// To display total numbers of rows in the table
		
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
		System.out.println("Total Rows: " + rows.size());
		
		Random rnd = new Random();
		int index = rnd.nextInt(rows.size());
		
		System.out.println(rows.get(index).getText());
		
		// To display all company names/ total number of companies from the table
		
	//	List<WebElement> companyNames = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[1]/a"));
	//	System.out.println("Total companies found: " + companyNames.size());
//		for (WebElement company : companyNames) {
			
      //      System.out.println(company.getText());
            
            // To display the highest price of a company from the list
            
          
            
            List<WebElement> currentPrice = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[4]"));
            
            //As the value is in double we are using double/ float can also be used
            
            float priceArray[] = new float[currentPrice.size()];
            for(int i = 0; i < currentPrice.size(); i++)
            {
            priceArray[i] = Float.parseFloat(currentPrice.get(i).getText().replace(",", ""));
            }
            // the above statement is converting the double/float type into string and replacing an , value ( type casting done )
            
            //sorting the array and printing the highest price
            
            Arrays.sort(priceArray);
            System.out.println("Highest Price" + priceArray[priceArray.length-1]);
            
            //printing the lowest price
            
            System.out.println("Highest Price" + priceArray[0]);
           

	}
	}

