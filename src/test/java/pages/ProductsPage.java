package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {
    private final WebDriver driver;
    private final By title = By.cssSelector(".title");
    private final By sortDropdown = By.cssSelector("[data-test='product-sort-container']");
    private final By backpackAddButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartLink = By.cssSelector(".shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        return "Products".equals(driver.findElement(title).getText());
    }

    public void sortLowToHigh() {
        new Select(driver.findElement(sortDropdown)).selectByValue("lohi");
    }

    public void addBackpackToCart() {
        driver.findElement(backpackAddButton).click();
    }

    public void openCart() {
        driver.findElement(cartLink).click();
    }
}
