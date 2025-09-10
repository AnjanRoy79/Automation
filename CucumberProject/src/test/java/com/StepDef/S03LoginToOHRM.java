package com.StepDef;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S03LoginToOHRM {
	WebDriver driver;
	
	@Given("Launch OHRM")
	public void launch_ohrm() {
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("Enter valid userName")
	public void enter_valid_user_name() {
	    driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
	}

	@When("Enter valid password")
	public void enter_valid_password() {
	    driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	}

	@When("Click on Login button")
	public void click_on_login_button() {
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("Dashboard page should display")
	public void dashboard_page_should_display() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	    System.out.println("Login Successfull");
	    driver.close();
	}

	@When("Enter invalid username")
	public void enter_invalid_username() {
	    driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Anjan");
	}

	@When("Enter invalid password")
	public void enter_invalid_password() {
	    driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Anjan123");
	}

	@When("Click on submit button")
	public void click_on_submit_button() {
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("Error message should display")
	public void error_message_should_display() {
	    Assert.assertTrue(driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText().contains("Invalid"));
	   System.out.println("Invalid Login Credentials");
	   driver.close();
	   
	}
}
