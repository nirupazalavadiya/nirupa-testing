
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlertsDemo {
    public static void main(String[] args) throws InterruptedException {
        // Start the WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            // Navigating to the Alerts demo page requested in the assignment image
            System.out.println("Navigating to https://demo.automationtesting.in/Alerts.html");
            driver.get("https://demo.automationtesting.in/Alerts.html");
            Thread.sleep(2000); // Wait for page to load

            // Step 1: The screenshot shows the "Alert with OK & Cancel" tab being active.
            // We need to click on that tab link first.
            System.out.println("Switching to 'Alert with OK & Cancel' tab...");
            driver.findElement(By.xpath("//a[normalize-space()='Alert with OK & Cancel']")).click();
            Thread.sleep(1000);

            // Step 2: Clicking the button that triggers the confirmation alert popup
            System.out.println("Clicking the button to trigger the alert popup...");
            driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
            Thread.sleep(2000); // Pause to let the student visually see the popup on screen

            // Step 3: Switching WebDriver control from the main page to the Alert popup
            Alert confirmAlert = driver.switchTo().alert();

            // Fetching and printing the text displayed inside the alert box
            String alertText = confirmAlert.getText();
            System.out.println("The alert popup says: " + alertText);

            // Step 4: The screenshot shows an alert with OK and Cancel buttons.
            // Let's dismiss it by clicking "Cancel".
            System.out.println("Clicking 'Cancel' to dismiss the alert...");
            confirmAlert.dismiss(); 
            
            // Note: If we wanted to click "OK", we would use: confirmAlert.accept();
            
            Thread.sleep(2000);
            System.out.println("Alert handled successfully!");

        } catch (Exception e) {
            System.out.println("An exception occurred: " + e.getMessage());
        } finally {
            System.out.println("Closing the browser.");
            driver.quit();
        }
    }
}
