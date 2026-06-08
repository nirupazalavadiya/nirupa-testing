package assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * 3. Maven Program to create TestNG with WebDriver
 */
public class TestNGWebDriverTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.out.println("TestNG: Setting up WebDriver...");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void verifyPageTitle() throws InterruptedException {
        System.out.println("TestNG: Running Test...");
        driver.get("https://www.google.com");
        
        String title = driver.getTitle();
        System.out.println("TestNG: Validating Page Title: " + title);
        
        // TestNG Assertion to verify the test passed
        Assert.assertTrue(title.contains("Google"), "Title does not match!");
        Thread.sleep(2000); // Pause to see the browser
    }

    @AfterTest
    public void tearDown() {
        System.out.println("TestNG: Closing Browser...");
        if (driver != null) {
            driver.quit();
        }
    }
}
