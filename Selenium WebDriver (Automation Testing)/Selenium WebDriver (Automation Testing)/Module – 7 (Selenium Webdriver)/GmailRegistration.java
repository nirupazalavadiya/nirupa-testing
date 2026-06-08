
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailRegistration {
    public static void main(String[] args) throws InterruptedException {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            
            // Navigating to the Google Account creation page
            System.out.println("Navigating to Google Account creation page...");
            driver.get("https://accounts.google.com/signup");
            
            // Waiting a bit for the page to load fully
            Thread.sleep(2000);

            // Filling in basic registration details as a student
            System.out.println("Filling in personal details...");
            
            // Locating the First Name input box by its name attribute
            WebElement firstNameBox = driver.findElement(By.name("firstName"));
            firstNameBox.sendKeys("Selenium");
            
            // Locating the Last Name input box
            WebElement lastNameBox = driver.findElement(By.name("lastName"));
            lastNameBox.sendKeys("Student");
            
            // Locating and clicking the 'Next' button
            // Since the button is a span, we can find the span and click its parent or the span itself
            WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']/.."));
            nextButton.click();
            
            Thread.sleep(3000); // Wait for the next page to load
            
            // Note for my assignment: Google has strong anti-bot mechanisms. 
            // Usually, it asks for Date of Birth, Gender, or even Phone verification next.
            // Full automation of Gmail sign-up is restricted by CAPTCHAs and OTPs.
            System.out.println("Clicked Next. The next steps usually require OTP or Captcha which cannot be automated fully without bypassing security!");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            System.out.println("Note: Google frequently changes their DOM structure, so locators might need updating.");
        } finally {
            // Always close the driver
            driver.quit();
        }
    }
}
