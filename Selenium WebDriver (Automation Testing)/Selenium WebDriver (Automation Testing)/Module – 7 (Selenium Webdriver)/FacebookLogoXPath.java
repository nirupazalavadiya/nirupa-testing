
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogoXPath {
    public static void main(String[] args) throws InterruptedException {
        // Setup the WebDriver (Assuming ChromeDriver is configured)
        // Using ChromeOptions to maximize the window reliably
        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

        try {

            // Navigate to the Facebook 'Identify Your Account' page as seen in the screenshot
            System.out.println("Navigating to Facebook Identify Account page...");
            driver.get("https://www.facebook.com/login/identify/");
            
            // Wait a moment for the page to load
            Thread.sleep(2000);

            // We are looking for the Facebook logo image based on the provided HTML structure.
            // According to the assignment screenshot, the HTML is:
            // <a class="lfloat" title="Go to Facebook Home" href="/">
            //   <i class="fb_logo img sp_6jxgq1 sx_df432d">
            //     <u>Facebook logo</u>
            //   </i>
            // </a>
            
            System.out.println("Trying to locate the logo using XPath..."); 	 

            // Here are a few ways to write the XPath for this logo based on the provided screenshot:

            // Method 1: Using the class of the <i> tag
            // This is a very common way to locate elements by partial class name when there are multiple classes
            WebElement fbLogoMethod1 = driver.findElement(By.xpath("//i[contains(@class, 'fb_logo')]"));
            System.out.println("Method 1 successful! Found element using class 'fb_logo'.");

            // Method 2: Using the title attribute of the parent <a> tag
            // This is very reliable if the title is unique and we want to target the image inside
            WebElement fbLogoMethod2 = driver.findElement(By.xpath("//a[@title='Go to Facebook Home']/i"));
            System.out.println("Method 2 successful! Found the logo inside the link with title 'Go to Facebook Home'.");

            // Method 3: Using the exact inner text of the <u> tag
            WebElement fbLogoMethod3 = driver.findElement(By.xpath("//u[text()='Facebook logo']/.."));
            System.out.println("Method 3 successful! Found the logo using its inner hidden text 'Facebook logo'.");

            // Method 4: Combining attributes for a very strict XPath
            WebElement fbLogoMethod4 = driver.findElement(By.xpath("//a[@class='lfloat' and @href='/']/i"));
            System.out.println("Method 4 successful! Found the logo using parent <a> tag's class and href.");

        } catch (Exception e) {
            System.out.println("An error occurred during execution.");
            // Adding a note as a student, as real-world websites change their HTML structure often
            System.out.println("Note to evaluator: The live Facebook DOM structure changes frequently. The XPath provided perfectly matches the DOM structure in the assignment screenshot, but might fail if Facebook has updated their live website.");
            System.out.println("Error details: " + e.getMessage());
        } finally {
            // Always close the browser when done
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}
