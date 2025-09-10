package com.StepDef;

import java.util.List;
import java.util.Map;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S06RegistrationWithTable {
	@Given("Launch the registration page")
	public void launch_the_registration_page() {
		System.out.println("Launching registration page");
	}

	@When("I enter following data")
	public void i_enter_following_data(io.cucumber.datatable.DataTable dataTable) {
		System.out.println(dataTable);
		
		List<List<String>>data = dataTable.asLists();
		for(List<String> d : data)
			System.out.println(d);
	}

	@Then("Registration should successful")
	public void registration_should_successful() {
		System.out.println("Thank you for registration");
	}
	
	
	@Given("Launch registration page in browser")
	public void launch_registration_page_in_browser() {
	    System.out.println("Welcome to Registration page");
	}

	@When("I will enter following data")
	public void i_will_enter_following_data(io.cucumber.datatable.DataTable dataTable) {
	    List<Map<String, String>>data = dataTable.asMaps();
	    
	    System.out.println(data);
	}

	@Then("Registration should be successful")
	public void registration_should_be_successful() {
		System.out.println("Thank you for registration");
	}
}