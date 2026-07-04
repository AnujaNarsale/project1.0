package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

public class CheckoutTest extends BaseTest {

    @Test(description = "Verify end-to-end checkout flow completes successfully")
    public void testEndToEndCheckout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isProductsPageDisplayed(), "Login failed");

        productsPage.addFirstProductToCart();
        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Item not added to cart");
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutInfo("John", "Doe", "12345");
        checkoutPage.finishCheckout();

        String confirmationMessage = checkoutPage.getOrderCompleteMessage();
        Assert.assertEquals(confirmationMessage, "Thank you for your order!",
                "Order confirmation message did not match expected text");
    }
}