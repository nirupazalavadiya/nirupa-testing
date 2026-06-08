package assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.assertTrue;

/**
 * 2. Maven Program to create JUnit with WebDriver
 */
public class JUnitWebDriverTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("JUnit: Setting up WebDriver...");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testGoogleSearch() throws InterruptedException {
        System.out.println("JUnit: Running Test...");
        driver.get("https://www.google.com");
        
        String title = driver.getTitle();
        System.out.println("JUnit: Validating Page Title: " + title);
        
        // JUnit Assertion to verify the test passed
        assertTrue("Title should contain Google", title.contains("Google"));
        Thread.sleep(2000); // Pause to see the browser
    }

    @After
    public void tearDown() {
        System.out.println("JUnit: Closing Browser...");
        if (driver != null) {
            driver.quit();
        }
    }
}
