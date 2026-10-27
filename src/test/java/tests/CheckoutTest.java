package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutTest extends BaseTest {
    @Test
    public void userCanCompleteCheckout() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        ProductsPage products = new ProductsPage(driver);
        products.addBackpackToCart();
        products.openCart();

        CartPage cart = new CartPage(driver);
        cart.checkout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.enterCustomerInformation("QA", "Tester", "60601");
        checkout.finishOrder();

        Assert.assertEquals(checkout.getConfirmationMessage(), "Thank you for your order!");
    }
}
