
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Tells JUnit to run this class as a Parameterized test
@RunWith(Parameterized.class)
public class JUnitParameterizedFacebook {
    private String email;
    private String password;
    private WebDriver driver;

    // Constructor gets the parameters
    public JUnitParameterizedFacebook(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Provides the data sets to the constructor
    @Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
            {"student1@test.com", "pass111"},
            {"student2@test.com", "pass222"}
        });
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testParameterizedLogin() throws InterruptedException {
        System.out.println("Testing Facebook login with: " + email);
        driver.get("https://www.facebook.com/");
        
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.name("login")).click();
        
        Thread.sleep(2000); // Pause to see it type the parameters
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
