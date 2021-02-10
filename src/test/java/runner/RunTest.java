package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features"},
        glue = "steps",
        monochrome = true, plugin = {"pretty", "html:Reports/cucumber" },
        tags= {"@testAutomationPractice"})
public class RunTest {

}
