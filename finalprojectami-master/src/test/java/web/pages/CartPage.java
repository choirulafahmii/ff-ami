package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    private WebDriver driver;

    //constructor
    private CartPage(WebDriver driver) {this.driver = driver;}

    //locator
    private By placeOrderButton = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");

    //Metode untuk klik tombol
    public void clickCheckoutButton () {
        WebElement checkoutBtn = driver.findElement(placeOrderButton);
        checkoutBtn.click();
    }
}
