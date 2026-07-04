package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By pageTitle = By.className("title");
    private By productItems = By.className("inventory_item");
    private By cartIcon = By.className("shopping_cart_link");
    private By cartBadge = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isProductsPageDisplayed() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        return title.getText().equalsIgnoreCase("Products");
    }

    public int getProductCount() {
        List<WebElement> items = driver.findElements(productItems);
        return items.size();
    }

    public void addProductToCartByName(String productName) {
        String addButtonId = "add-to-cart-" + productName.toLowerCase()
                .replace(" ", "-")
                .replace(".", "");
        WebElement addButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id(addButtonId)));
        addButton.click();
    }

    public void addFirstProductToCart() {
        List<WebElement> addButtons = driver.findElements(
                By.cssSelector("button.btn_inventory"));
        wait.until(ExpectedConditions.elementToBeClickable(addButtons.get(0)));
        addButtons.get(0).click();
    }

    public String getCartItemCount() {
        try {
            return driver.findElement(cartBadge).getText();
        } catch (Exception e) {
            return "0";
        }
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}