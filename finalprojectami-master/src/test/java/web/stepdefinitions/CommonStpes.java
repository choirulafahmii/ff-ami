package web.stepdefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.pages.HomePage;

import java.sql.Driver;

public class CommonStpes {
    private static WebDriver driver;
    private static HomePage homePage;


    @Given("user open homepage Demoblaze")
    public void userOpenHomepageDemoblaze() {
        driver = Hooks.getDriver();
        homePage = new HomePage(driver);
        homePage.openURL("https://www.demoblaze.com/");
    }
}
