package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {
    @Test
    public void validUserCanLogin() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        Assert.assertTrue(new ProductsPage(driver).isLoaded());
    }

    @Test
    public void invalidUserCannotLogin() {
        LoginPage login = new LoginPage(driver);
        login.login("invalid_user", "wrong_password");
        Assert.assertTrue(login.getErrorMessage().contains("Username and password do not match"));
    }
}
