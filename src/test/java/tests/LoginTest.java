package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Verify user can log in with valid credentials")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isProductsPageDisplayed(),
                "Products page was not displayed after valid login");
    }

    @Test(priority = 2, description = "Verify error message on invalid login")
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalid_user", "wrong_password");

        Assert.assertTrue(loginPage.isErrorDisplayed(),
                "Error message was not displayed for invalid login");
        Assert.assertTrue(loginPage.getErrorText().contains("do not match"),
                "Unexpected error message text");
    }

    @Test(priority = 3, description = "Verify error message on empty credentials")
    public void testEmptyCredentialsLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");

        Assert.assertTrue(loginPage.isErrorDisplayed(),
                "Error message was not displayed for empty credentials");
    }
}