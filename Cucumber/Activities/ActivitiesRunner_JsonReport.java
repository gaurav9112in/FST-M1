package cucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "Features",
	    glue = {"stepDefinitions"},
	    tags = "@activity2_6",
	    plugin = {"html: test-reports"},	    
	    monochrome = true
	)

public class ActivitiesRunner_JsonReport {
  //empty
}
