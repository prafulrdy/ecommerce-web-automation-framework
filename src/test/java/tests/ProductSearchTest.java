package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductSearchTest extends BaseTest {
    @Test
    public void productsCanBeSortedLowToHigh() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        ProductsPage products = new ProductsPage(driver);
        Assert.assertTrue(products.isLoaded());
        products.sortLowToHigh();
        Assert.assertTrue(products.isLoaded());
    }
}
