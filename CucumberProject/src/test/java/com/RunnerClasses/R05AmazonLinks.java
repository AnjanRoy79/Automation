package com.RunnerClasses;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/F05AmazonLinks.feature", 
	glue = "com.StepDef",
	//tags = "@SellLink", tags = "@Allinks" // defined in the feature file which scenario to execute or skip
	publish = true,
	plugin = {"json:Reports/Cucumber-json.json", 
			  "junit:Reports/xmlReport.xml"})
public class R05AmazonLinks {
	
	/*
	 Execute Single Scenario:		tags = "@SellLink"
	 Execute Multiple Scenarios:	tags = "@SellLink or @BestSell"
	 Skip Single Scenario:			tags = "not @Deal"
	 Skip Multiple Scenarios:		tags = "not @Deal and not @Mobile"
	 Run all the scenario using tags = give any name before all the scenario and use that name 
	 in the tags. EG: tags = "@AllLinks"
	 */

}
