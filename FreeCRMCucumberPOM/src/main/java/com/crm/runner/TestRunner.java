package com.crm.runner;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "C:\\Selenium Setup\\FreeCRMCucumberPOM\\src\\main\\java\\com\\crm\\features\\freecrm.feature"
			,glue={"com/crm/stepDefinitions"}
			,format = {"pretty", "html:test-output", "json:json_output/cucumber.json" , "junit:junit_xml/cucumber.xml"}
			,monochrome = true 
			,strict = true
			,tags = {"@RegressionTest"}
			,dryRun = false
			)
	
	public class TestRunner {
		
}
