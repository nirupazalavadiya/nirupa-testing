
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnitFacebookLogin {
    
    @Test
    public void testFacebookLogin() throws InterruptedException {
        // Setup the WebDriver
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.manage().window().maximize();
            
            // Navigate to Facebook
            System.out.println("Navigating to Facebook for JUnit Test...");
            driver.get("https://www.facebook.com/");
            
            // Input login details
            driver.findElement(By.id("email")).sendKeys("testuser@example.com");
            driver.findElement(By.id("pass")).sendKeys("wrongpassword123");
            
            // Click the login button
            driver.findElement(By.name("login")).click();
            
            Thread.sleep(3000); // Wait to observe the result
            System.out.println("JUnit Facebook login test executed successfully.");
            
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
