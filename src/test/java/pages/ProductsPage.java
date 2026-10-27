package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By title = By.cssSelector(".title");
    private final By sortDropdown = By.cssSelector("[data-test='product-sort-container']");
    private final By backpackAddButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartLink = By.cssSelector(".shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isLoaded() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(title)
        ).getText().equals("Products");
    }

    public void sortLowToHigh() {
        wait.until(
            ExpectedConditions.elementToBeClickable(sortDropdown)
        );

        new Select(driver.findElement(sortDropdown))
            .selectByValue("lohi");
    }

    public void addBackpackToCart() {
        wait.until(
            ExpectedConditions.elementToBeClickable(backpackAddButton)
        ).click();
    }

    public void openCart() {
        wait.until(
            ExpectedConditions.elementToBeClickable(cartLink)
        ).click();
    }
}
