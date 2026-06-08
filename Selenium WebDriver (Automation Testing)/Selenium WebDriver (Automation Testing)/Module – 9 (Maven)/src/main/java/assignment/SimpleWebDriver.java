package assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * 1. Simple Maven WebDriver Program (No testing framework)
 */
public class SimpleWebDriver {
    public static void main(String[] args) {
        System.out.println("Starting Simple Maven WebDriver Program...");
        
        // Setup WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to a website
            driver.get("https://www.google.com");
            System.out.println("Successfully opened website.");
            System.out.println("Page title is: " + driver.getTitle());
            Thread.sleep(2000); // Pause to see the browser
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
            System.out.println("Simple WebDriver Program executed successfully.");
        }
    }
}
