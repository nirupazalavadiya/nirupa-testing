
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGGmailLogin {
    private WebDriver driver;

    // @BeforeTest runs once before any @Test methods in the <test> tag
    @BeforeTest
    public void setUp() {
        System.out.println("Setting up WebDriver in @BeforeTest...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testGmailLogin() throws InterruptedException {
        System.out.println("Running Gmail login process in @Test...");
        driver.get("https://mail.google.com/");
        Thread.sleep(2000);
        
        driver.findElement(By.id("identifierId")).sendKeys("testngstudent@gmail.com");
        driver.findElement(By.xpath("//span[text()='Next']/..")).click();
        Thread.sleep(2000);
        
        System.out.println("TestNG Gmail login test executed.");
    }

    // @AfterTest runs once after all @Test methods in the <test> tag
    @AfterTest
    public void tearDown() {
        System.out.println("Closing browser in @AfterTest...");
        if (driver != null) {
            driver.quit();
        }
    }
}
