package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

public class AddToCartTest extends BaseTest {

    @Test(description = "Verify product can be added to cart and cart badge updates")
    public void testAddProductToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isProductsPageDisplayed(), "Login failed");

        productsPage.addFirstProductToCart();
        Assert.assertEquals(productsPage.getCartItemCount(), "1",
                "Cart badge did not update after adding product");

        productsPage.goToCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getCartItemCount(), 1,
                "Cart page does not show the correct number of items");
    }
}