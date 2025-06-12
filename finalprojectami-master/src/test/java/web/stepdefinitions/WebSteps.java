package web.stepdefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;


public class WebSteps {
    protected WebDriver driver;

    // @before
    public WebSteps(){
        driver = Hooks.getDriver();
    }

    @Given("user open Demoblaze Website")
    public void userOpenDemoblazeWebsite() {
        driver.get("https://demoblaze.com/");
    }

    // @after
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
