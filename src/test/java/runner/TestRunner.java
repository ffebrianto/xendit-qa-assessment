package runner;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.BaseTest;

@CucumberOptions(
        plugin = {"pretty", "html:target/report/cucumber-html-report.html"},
        glue = "stepdefs",
        features = "src\\test\\resources\\features")
public class TestRunner extends AbstractTestNGCucumberTests {
}
