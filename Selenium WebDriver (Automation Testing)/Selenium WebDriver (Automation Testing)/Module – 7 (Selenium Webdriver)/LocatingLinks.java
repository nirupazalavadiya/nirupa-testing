
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingLinks {
    public static void main(String[] args) throws InterruptedException {
        // Setting up the ChromeDriver
        // Note: As a student, I know in newer Selenium versions, we don't always need to set System.setProperty if we use Selenium Manager.
        WebDriver driver = new ChromeDriver();

        try {
            // Maximizing the window so it's easier to see
            driver.manage().window().maximize();

            // Navigating to the practice website
            driver.get("https://the-internet.herokuapp.com/");

            // Finding a link using its exact text "A/B Testing"
            System.out.println("Clicking on link using linkText()...");
            WebElement linkTextElement = driver.findElement(By.linkText("A/B Testing"));
            linkTextElement.click();
            
            // Pausing for a second to see the result
            Thread.sleep(1000);
            
            // Going back to the main page to try partialLinkText
            driver.navigate().back();
            Thread.sleep(1000);

            // Finding a link using part of its text "Broken" (for "Broken Images")
            System.out.println("Clicking on link using partialLinkText()...");
            WebElement partialLinkElement = driver.findElement(By.partialLinkText("Broken"));
            partialLinkElement.click();

            // Pausing to see the result
            Thread.sleep(2000);

        } catch (Exception e) {
            // If something goes wrong, we catch it here
            System.out.println("Oops, an error occurred: " + e.getMessage());
        } finally {
            // Always remember to close the browser after testing!
            System.out.println("Closing the browser.");
            driver.quit();
        }
    }
}
