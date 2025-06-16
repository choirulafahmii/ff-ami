package web.stepdefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Beta;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks {
    private static WebDriver driver;
    public static WebDriverWait wait;

    public static WebDriver getDriver() {
        if(driver == null) {
            // Initialize the WebDriver instance here
            // For example, using ChromeDriver:
            driver = WebDriverManager.chromedriver().create();
            driver.manage().window().maximize();
            driver.get("https://www.demoblaze.com/");

            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        }
        return driver;
    }

    public static void quitDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
