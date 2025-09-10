package com.RunnerClasses;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/test/resources/F02GoogleSearch.feature", glue = "com.StepDef")
public class R02GoogleSearch {

}
