package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature/SignIn.feature"
		,glue = {"stepdefinition"},
		dryRun=false,
		monochrome=true	
		//,format={"pretty "," html:test_output"}
		)

public class TestRunner {
	

}