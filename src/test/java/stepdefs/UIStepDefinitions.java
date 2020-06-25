package stepdefs;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import service.NavigationService;
import service.ValidationService;
import utilities.BaseTest;

import java.io.File;
import java.util.Date;

public class UIStepDefinitions {

    private static NavigationService navigationService;
    private static ValidationService validationService;

    public UIStepDefinitions(NavigationService navigationService , ValidationService validationService){
        this.navigationService = navigationService;
        this.validationService = validationService;
    }

    public void setUp(){
        MutablePicoContainer picoContainer = new DefaultPicoContainer();
        picoContainer.addComponent(navigationService);
        picoContainer.addComponent(validationService);
    }

    @Given("Open chrome browser and start application")
    public void open_chrome_browser_and_start_application() {
        navigationService.openOnlineCalculator();
    }

    @When("I enter following values and press CE button")
    public void i_enter_following_values_and_press_CE_button(io.cucumber.datatable.DataTable dataTable) {
        navigationService.enterInput(dataTable.asList().get(1),dataTable.asList().get(3),dataTable.asList().get(5));
    }

    @Then("I should be able to see")
    public void i_should_be_able_to_see(io.cucumber.datatable.DataTable dataTable) {
        validationService.validateOutput(navigationService.getResult(),dataTable.asList().get(1));
    }

    @After
    public void afterScenario(Scenario scenario){
        if(scenario.isFailed()){
            try{
                File screenshot = ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.FILE);
                File reportFile = new File("target/report/"+scenario.getName() + "_" + scenario.getLine() +".jpg");
                FileUtils.copyFile(screenshot, reportFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}