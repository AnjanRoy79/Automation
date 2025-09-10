package com.StepDef;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class S01GoogleTitle {
	WebDriver driver;
	String title;
	@Given("Launch Google")
	public void launch_google() {

	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://google.com/");
	}

	@When("Read the Title")
	public void read_the_title() {
		title = driver.getTitle();
	}

	@When("Display the Title")
	public void display_the_title() {
		System.out.println("Title: " + title);
		
	}

	@Then("Title should be Google")
	public void title_should_be_google() {
		Assert.assertTrue(title.equals("Google"));
		driver.close();
	}

}
