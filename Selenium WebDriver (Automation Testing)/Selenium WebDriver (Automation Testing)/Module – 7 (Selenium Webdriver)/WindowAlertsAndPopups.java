
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowAlertsAndPopups {
    public static void main(String[] args) throws InterruptedException {
        // Start the Chrome browser
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            
            // Navigating to a page with different types of JavaScript alerts
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");

            // --- 1. Simple Alert ---
            System.out.println("Trying simple alert...");
            // Find and click the button to trigger a basic alert
            driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
            Thread.sleep(1000); // Waiting to see the popup
            
            // Switching control to the alert popup
            Alert simpleAlert = driver.switchTo().alert(); 
            System.out.println("Alert text says: " + simpleAlert.getText());
            simpleAlert.accept(); // Clicking "OK" on the alert
            Thread.sleep(1000);

            // --- 2. Confirmation Alert (Confirm Box) ---
            System.out.println("Trying confirmation alert...");
            driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
            Thread.sleep(1000);
            
            Alert confirmAlert = driver.switchTo().alert();
            System.out.println("Confirm text says: " + confirmAlert.getText());
            confirmAlert.dismiss(); // Clicking "Cancel" on the confirmation box
            System.out.println("I clicked Cancel.");
            Thread.sleep(1000);

            // --- 3. Prompt Alert ---
            System.out.println("Trying prompt alert...");
            driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
            Thread.sleep(1000);
            
            Alert promptAlert = driver.switchTo().alert();
            System.out.println("Prompt text says: " + promptAlert.getText());
            // Typing some text into the alert prompt box
            promptAlert.sendKeys("Hello from a Selenium Student!"); 
            promptAlert.accept(); // Clicking "OK" after typing
            System.out.println("Typed text and accepted the prompt.");
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            System.out.println("Test complete. Closing browser.");
            driver.quit();
        }
    }
}
