
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalHyperlinks {
    public static void main(String[] args) throws InterruptedException {
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the target web page mentioned in the assignment
            String targetUrl = "https://qavbox.github.io/demo/webtable/";
            System.out.println("Navigating to: " + targetUrl);
            driver.get(targetUrl);
            
            // Adding a short pause to ensure the page is fully loaded
            Thread.sleep(3000);

            // In HTML, hyperlinks are defined using the <a> (anchor) tag.
            // We use driver.findElements() with By.tagName("a") to find all of them.
            System.out.println("Scanning the page for all hyperlink elements...");
            List<WebElement> allHyperlinks = driver.findElements(By.tagName("a"));

            // Getting the total size of the list gives us the count of hyperlinks
            int totalLinksCount = allHyperlinks.size();
            
            System.out.println("==================================================");
            System.out.println("Total number of hyperlinks found on the page: " + totalLinksCount);
            System.out.println("==================================================");

            // As a student, it's good practice to print out a few to verify they are actually links
            System.out.println("\nPrinting details of the first 5 links for verification:");
            for (int i = 0; i < Math.min(5, totalLinksCount); i++) {
                WebElement link = allHyperlinks.get(i);
                String linkText = link.getText();
                String href = link.getAttribute("href");
                System.out.println((i + 1) + ". Link Text: '" + linkText + "' | Target URL: " + href);
            }

        } catch (Exception e) {
            // Catching any exceptions that might occur
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Quitting the driver to close the browser
            System.out.println("Closing the browser.");
            driver.quit();
        }
    }
}
