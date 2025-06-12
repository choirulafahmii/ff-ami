package web.pages;

import io.cucumber.java.cs.Ale;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    WebDriverWait wait; //declare variable wait
    // constructor untuk menerima Webdriver
    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    //locator tombol add to cart
    private By addToCartButton = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");

    // metode untuk menambahkan produk ke keranjang
    public void clickAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        button.click();
    }

    public void acceptAlert (){
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No Alert present");
        }
    }
}
