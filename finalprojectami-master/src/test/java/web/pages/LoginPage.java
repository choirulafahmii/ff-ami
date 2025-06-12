package web.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locator
    private final By usernameField = By.id("loginusername");
    private final By passwordField = By.id("loginpassword");
    private final By loginButton = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    private final By logoutButton = By.id("logout2");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //input username and password
    public void enterUsername(String username) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        input.clear();
        input.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        input.clear();
        input.sendKeys(password);
    }

    //klik tombol login
    public void clickLoginButton(){
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            button.click();
        }catch (ElementClickInterceptedException | TimeoutException e) {
            System.out.println("⚠️ Gagal klik tombol login, coba pakai JavaScript.");
            WebElement button = driver.findElement(loginButton);
            ((JavascriptExecutor) driver).executeScript("argument[0].click();", button);
        }
    }

    //cek apakah berhasil login
    public boolean isLoginSuccessfull(){
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("Login gagal atau timeout: tombol logout tidak muncul");
            return false;
        }
    }

    //ambil pesan error dari alert pop up (jika login gagal)
    public String getErrorMessage(){
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String text = alert.getText();
            alert.accept();
            return text;
        } catch (TimeoutException e) {
            return "No alert found.";
        }
    }

    public WebDriver getDriver() {
        return driver;
    }


}
