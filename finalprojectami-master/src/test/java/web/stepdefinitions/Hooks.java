package web.stepdefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Beta;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    private static WebDriver driver;

    @Before
    public static void setUp(){
        ChromeOptions options= new ChromeOptions();

        options.addArguments("--headless"); //for ci cd running

        //setup chromedriver via WebDriverManager
        WebDriverManager.chromedriver().setup();
        System.out.println("Webdriver initialized successfully");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

    public static WebDriver getDriver() {
        try {
            if (driver != null) {
                setUp();
            }
            driver.getTitle(); //simple harmless call to check session
        } catch (NoSuchSessionException e) {
            setUp();
        } catch (Exception e) {
            //other expectation can also indicate driver issues
            setUp();
        }

        return driver;
    }

    public boolean isSessionActive(WebDriver driver) {
        try {
            if (driver == null){
                return false;
            }
            driver.getTitle(); //simple harmless call to check session
            return true;
        } catch (NoSuchSessionException e){
            return false;
        } catch (Exception e) {
            // Other exceptions can also indicate driver issues
            return false;
        }
    }
}
