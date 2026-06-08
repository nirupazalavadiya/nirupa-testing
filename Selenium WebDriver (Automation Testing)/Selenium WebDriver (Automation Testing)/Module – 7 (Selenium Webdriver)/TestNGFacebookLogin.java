
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGFacebookLogin {
    
    // Note the import is org.testng.annotations.Test, not org.junit.Test
    @Test
    public void testFacebookLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.manage().window().maximize();
            System.out.println("Running TestNG Facebook Login test...");
            driver.get("https://www.facebook.com/");
            
            driver.findElement(By.id("email")).sendKeys("testnguser@example.com");
            driver.findElement(By.id("pass")).sendKeys("testngpass123");
            driver.findElement(By.name("login")).click();
            
            Thread.sleep(3000);
            System.out.println("TestNG Facebook login test executed successfully.");
            
        } finally {
            driver.quit();
        }
    }
}
