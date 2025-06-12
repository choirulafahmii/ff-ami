package web.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import web.pages.HomePage;
import web.pages.LoginPage;

public class LoginSteps {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    public LoginSteps() {
        this.driver = Hooks.getDriver();
        this.homePage = new HomePage(driver);
    }

    @When("user click login button")
    public void userClickLoginButton() {
        homePage.clickLoginButton();
        loginPage = new LoginPage(driver);
    }

    @And("user input username {string} and password {string}")
    public void userInputUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("user hit login button")
    public void userHitLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("system direct to homepage")
    public void systemDirectToHomepage() {
        Assert.assertTrue("Login gagal, tombol logout tidak ditemukan!", loginPage.isLoginSuccessfull());
    }
}
