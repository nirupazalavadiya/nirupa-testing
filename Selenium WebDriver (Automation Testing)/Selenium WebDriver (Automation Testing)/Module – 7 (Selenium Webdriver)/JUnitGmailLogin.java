
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnitGmailLogin {
    private WebDriver driver;

    // @Before method runs before every @Test method
    @Before
    public void setUp() {
        System.out.println("Setting up WebDriver in @Before...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // @Test method contains the actual test logic
    @Test
    public void testGmailLogin() throws InterruptedException {
        System.out.println("Running Gmail login process in @Test...");
        driver.get("https://mail.google.com/");
        Thread.sleep(2000);
        
        // Note: Gmail blocks automated browsers. This is just for structural demonstration.
        driver.findElement(By.id("identifierId")).sendKeys("teststudent@gmail.com");
        driver.findElement(By.xpath("//span[text()='Next']/..")).click();
        Thread.sleep(2000);
        
        System.out.println("Gmail login test executed.");
    }

    // @After method runs after every @Test method
    @After
    public void tearDown() {
        System.out.println("Closing browser in @After...");
        if (driver != null) {
            driver.quit();
        }
    }
}
