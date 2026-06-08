package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class ShopEZTests extends BaseTest {

    @Test(priority = 1, description = "Verify Login functionality")
    public void testLoginFunctionality() {
        test.info("Navigating to https://shop-ez.com");
        driver.get("https://shop-ez.com");

        LoginPage loginPage = new LoginPage(driver);
        
        test.info("Entering username and password");
        // Using dummy credentials as it's an assessment framework demo
        loginPage.enterUsername("student_user");
        loginPage.enterPassword("password123");
        
        test.info("Clicking on Login");
        HomePage homePage = loginPage.clickLogin();

        test.info("Asserting redirection to home page");
        // Asserting based on URL or a specific element on the Home page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("home") || currentUrl.equals("https://shop-ez.com/"), 
                "User was not redirected to the home page.");
    }

    @Test(priority = 2, description = "Automate the product search and add-to-cart workflow")
    public void testSearchAndAddToCart() {
        test.info("Navigating to https://shop-ez.com (Assuming user is logged in or can search as guest)");
        driver.get("https://shop-ez.com");
        
        HomePage homePage = new HomePage(driver);
        
        int initialCartCount = homePage.getCartCount();
        test.info("Initial cart count: " + initialCartCount);

        test.info("Searching for a product: Laptop");
        homePage.searchForProduct("Laptop");

        test.info("Clicking on a product from search results");
        homePage.clickFirstProduct();

        test.info("Adding product to the cart");
        homePage.addToCart();

        test.info("Asserting that the cart count increases");
        int updatedCartCount = homePage.getCartCount();
        Assert.assertTrue(updatedCartCount > initialCartCount, 
                "Cart count did not increase after adding a product. " +
                "Expected greater than " + initialCartCount + ", but got " + updatedCartCount);
    }
}
