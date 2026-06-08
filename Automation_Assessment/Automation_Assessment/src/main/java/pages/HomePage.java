package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtils;

public class HomePage extends BasePage {

    @FindBy(id = "searchBox") // Adjust locator
    private WebElement searchInput;

    @FindBy(id = "searchButton") // Adjust locator
    private WebElement searchButton;

    @FindBy(css = ".product-item:first-child .product-title") // Adjust locator for first product
    private WebElement firstProductResult;

    @FindBy(id = "addToCartBtn") // Adjust locator
    private WebElement addToCartButton;

    @FindBy(id = "cartCount") // Adjust locator
    private WebElement cartCountElement;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchForProduct(String productName) {
        WaitUtils.waitForElementToBeVisible(driver, By.id("searchBox"), 10);
        searchInput.clear();
        searchInput.sendKeys(productName);
        searchButton.click();
    }

    public void clickFirstProduct() {
        WaitUtils.waitForElementToBeClickable(driver, By.cssSelector(".product-item:first-child .product-title"), 10);
        firstProductResult.click();
    }

    public void addToCart() {
        WaitUtils.waitForElementToBeClickable(driver, By.id("addToCartBtn"), 10);
        addToCartButton.click();
    }

    public int getCartCount() {
        WaitUtils.waitForElementToBeVisible(driver, By.id("cartCount"), 10);
        String countText = cartCountElement.getText();
        try {
            return Integer.parseInt(countText);
        } catch (NumberFormatException e) {
            return 0; // Return 0 if count is empty or invalid
        }
    }
}
