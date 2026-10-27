package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private final WebDriver driver;
    private final By cartItemName = By.cssSelector(".inventory_item_name");
    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getItemName() {
        return driver.findElement(cartItemName).getText();
    }

    public void checkout() {
        driver.findElement(checkoutButton).click();
    }
}
