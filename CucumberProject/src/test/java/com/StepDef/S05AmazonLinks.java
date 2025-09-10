package com.StepDef;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S05AmazonLinks {
	WebDriver driver;
	
	//@Before // using hook after and before
	public void beforeScenario()
	{
		
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://www.amazon.in/");
	}
	//@After
	public void closeBrowser()
	{
		driver.close();
	}
	
	@Given("Launch Amazon site")
	public void launch_amazon_site() {
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://www.amazon.in/");
	}

	@When("Click on Sell link")
	public void click_on_sell_link() {
		driver.findElement(By.partialLinkText("Sell")).click();
	}

	@Then("Sell page should display")
	public void sell_page_should_display() {
		 Assert.assertTrue(driver.getTitle().contains("Categories"));
		 System.out.println("Sell page displayed");
		//driver.close();
	 	}

	@When("Click on BestSellers link")
	    public void click_on_best_sellers_link() {
	    driver.findElement(By.partialLinkText("Best")).click();
	 	}

	@Then("Bestsellers page should display")
	public void bestsellers_page_should_display() {
		Assert.assertTrue(driver.getTitle().contains("Bestsellers"));
		System.out.println("Bestsellers page displayed");
		//driver.close();
	}

	@When("Click on Mobiles link")
	public void click_on_mobiles_link() {
		driver.findElement(By.partialLinkText("Mobile")).click();
	}

	@Then("Mobiles page should display")
	public void mobiles_page_should_display() {
		Assert.assertTrue(driver.getTitle().contains("Mobile"));
		System.out.println("Mobiles page displayed");
		//driver.close();
	}

	@When("Click on Todays deal link")
	public void click_on_todays_deal_link() {
		driver.findElement(By.partialLinkText("Today")).click();    
	}

	@Then("Todays deal page should display")
	public void todays_deal_page_should_display() {
		Assert.assertTrue(driver.getTitle().contains("Deals"));
		System.out.println("Todays deal page displayed");
		//driver.close();
	}
}