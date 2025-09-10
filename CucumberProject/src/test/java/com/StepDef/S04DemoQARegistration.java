package com.StepDef;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S04DemoQARegistration {
	WebDriver driver;
	@Given("Launch DemoQA site {string}")
	public void launch_demo_qa_site(String URL) {
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get(URL);
	}

	@When("Enter first Name as {string}")
	public void enter_first_name_as(String Fname) {
		 driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(Fname);
	}

	@When("Enter Last Name as {string}")
	public void enter_last_name_as(String Lname) {
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(Lname);
	}

	@Then("Data should entered")
	public void data_should_entered() {
	System.out.println("First Name: " + driver.findElement(By.xpath("//input[@id='firstName']")).getAttribute("value"));
	System.out.println("Last Name: " + driver.findElement(By.xpath("//input[@id='lastName']")).getAttribute("value"));
	driver.close();
	}

}
