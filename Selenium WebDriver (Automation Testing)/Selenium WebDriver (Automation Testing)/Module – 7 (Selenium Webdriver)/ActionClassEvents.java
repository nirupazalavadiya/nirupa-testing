
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassEvents {
    public static void main(String[] args) throws InterruptedException {
        // Setting up the WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            // Creating an object of Actions class to handle advanced mouse and keyboard events
            Actions actions = new Actions(driver);

            // ==========================================
            // 1. Mouse Hover Event
            // ==========================================
            System.out.println("Navigating to Automation Demo Site for Mouse Hover...");
            driver.get("https://demo.automationtesting.in/Register.html");
            Thread.sleep(2000);

            // Locating the 'Widgets' menu item which triggers a dropdown on hover
            System.out.println("Performing Mouse Hover over 'Widgets' menu...");
            WebElement widgetsMenu = driver.findElement(By.xpath("//a[contains(text(),'Widgets')]"));
            
            // Use moveToElement() to simulate moving the mouse over the element
            actions.moveToElement(widgetsMenu).perform();
            Thread.sleep(3000); // Pausing so we can visually see the sub-menu appear
            
            // ==========================================
            // 2. Keyboard Event & Context Menu (Right Click)
            // ==========================================
            System.out.println("Navigating to Facebook to test keyboard events (as shown in the assignment screenshot)...");
            driver.get("https://www.facebook.com/");
            Thread.sleep(2000);

            // Locating the email/phone input field
            WebElement emailField = driver.findElement(By.id("email"));

            System.out.println("Typing 'HELLO' using SHIFT key, selecting it, and opening right-click menu...");
            
            // Performing a chain of actions matching the screenshot:
            // 1. Click the field to focus
            // 2. Hold down SHIFT key
            // 3. Type 'hello' (which will be capitalized to HELLO)
            // 4. Release SHIFT key
            // 5. Double click to highlight the word 'HELLO' (like in the screenshot)
            // 6. Right-click (context click) to show the copy/paste menu
            actions.moveToElement(emailField)
                   .click()
                   .keyDown(Keys.SHIFT)
                   .sendKeys("hello")
                   .keyUp(Keys.SHIFT)
                   .doubleClick()
                   .contextClick()
                   .build()
                   .perform();
                   
            Thread.sleep(4000); // Pausing so we can see the highlighted text and right-click menu

            System.out.println("Action Class Events executed successfully!");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            System.out.println("Closing the browser.");
            driver.quit();
        }
    }
}
