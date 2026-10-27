package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartTest extends BaseTest {
    @Test
    public void userCanAddProductToCart() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        ProductsPage products = new ProductsPage(driver);
        products.addBackpackToCart();
        products.openCart();
        Assert.assertEquals(new CartPage(driver).getItemName(), "Sauce Labs Backpack");
    }
}
