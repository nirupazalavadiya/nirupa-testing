
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownSelection {
    public static void main(String[] args) throws InterruptedException {
        // Setup the WebDriver using ChromeOptions to maximize the window reliably
        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

        try {

            // Navigate to the registration page mentioned in the assignment image
            System.out.println("Navigating to https://demo.automationtesting.in/Register.html");
            driver.get("https://demo.automationtesting.in/Register.html");
            
            // Add a small pause to allow the page to load completely
            Thread.sleep(2000);

            // Locate the 'Skills' dropdown element.
            // On this specific website, the Skills dropdown has an ID attribute of 'Skills'
            WebElement skillsDropdownElement = driver.findElement(By.id("Skills"));

            // Since it's a standard <select> HTML tag, we use the Selenium Select class
            Select skillsDropdown = new Select(skillsDropdownElement);

            // --- Demonstrating different ways to select an option from a dropdown ---

            // Method 1: Select by Visible Text (This is what the user actually sees on the screen)
            System.out.println("Method 1: Selecting 'Android' using visible text...");
            skillsDropdown.selectByVisibleText("Android");
            Thread.sleep(2000); // Pause so we can visually verify the selection

            // Method 2: Select by Index (0 is 'Select Skills', 1 is 'Adobe InDesign', etc.)
            // Let's pick the 5th item in the list (which should be 'APIs')
            System.out.println("Method 2: Selecting the 5th option using index...");
            skillsDropdown.selectByIndex(5); 
            Thread.sleep(2000); // Pause again

            // Method 3: Select by Value attribute (the 'value' attribute of the <option> tag in HTML)
            System.out.println("Method 3: Selecting 'C++' using the value attribute...");
            skillsDropdown.selectByValue("C++");
            Thread.sleep(2000); // Pause again

            System.out.println("Dropdown selection script executed successfully!");

        } catch (Exception e) {
            // Handling any potential exceptions (e.g., element not found, timeout, etc.)
            System.out.println("An error occurred during execution: " + e.getMessage());
        } finally {
            // Ensuring the browser is closed after the script finishes, even if it crashes
            System.out.println("Closing the browser.");
            driver.quit();
        }
    }
}
