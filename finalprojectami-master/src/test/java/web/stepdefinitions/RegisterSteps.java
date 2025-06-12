package web.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.pages.RegisterPage;

import java.util.UUID;

public class RegisterSteps {
    private WebDriver driver;
    private RegisterPage RegisterPage;
    private String uniqueUserName;

    //generate username unik menggunakan uuid
    private String generateUniqueUsername(){
        return "user" + UUID.randomUUID().toString().substring(0, 8); //contoh: usera1b2c3d4
    }

    public RegisterSteps(){
        this.driver = Hooks.getDriver();
        this.RegisterPage = new RegisterPage(driver);
    }


    @When("user click Sign up menu")
    public void userClickSignUpMenu() {
        RegisterPage.openSignUpForm();
        uniqueUserName = generateUniqueUsername();
    }

    @And("user input username {string}")
    public void userInputUsername(String username) {
        // Jika username yang diberikan adalah "random", gunakan username unik yang sudah dibuat
        if (username.equalsIgnoreCase("random")){
            username = uniqueUserName;
        }
        RegisterPage.enterUsername(username);
    }

    @And("user input password {string}")
    public void userInputPassword(String password) {
        RegisterPage.enterPassword(password);
    }

    @And("user click Sign up button")
    public void userClickSignUpButton() {
        RegisterPage.clickSignUp();
    }

    @Then("system show message {string}")
    public void systemShowMessage(String expectedMessage) {
        String actualMessage = RegisterPage.getAlertMessage();
        if (!actualMessage.equals(expectedMessage)){
            throw new AssertionError("Pesan yang diharapkan" + expectedMessage + "tetapi yang muncul" + actualMessage);
        }
    }
}
