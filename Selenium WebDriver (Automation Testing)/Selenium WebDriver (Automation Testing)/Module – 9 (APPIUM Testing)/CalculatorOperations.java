import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class CalculatorOperations {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting Calculator Operations on Real Device...");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "MyAndroidPhone");
        
        // IMPORTANT: Replace with your actual physical phone's UDID
        caps.setCapability(MobileCapabilityType.UDID, "YOUR_UDID_HERE"); 
        
        // NOTE: The ApiDemos application does NOT contain a calculator. 
        // Therefore, we connect to the built-in Android Google Calculator app instead!
        caps.setCapability("appPackage", "com.google.android.calculator"); 
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        // (If your phone uses a different calculator app, you will need to update the package name above)

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(3000);

        // --- 1. Addition: 5 + 3 = 8 ---
        System.out.println("Calculating Addition...");
        driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        driver.findElement(By.id("com.google.android.calculator:id/clr")).click(); // Clear

        // --- 2. Subtraction: 9 - 4 = 5 ---
        System.out.println("Calculating Subtraction...");
        driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        driver.findElement(By.id("com.google.android.calculator:id/clr")).click(); // Clear

        // --- 3. Multiplication: 4 * 2 = 8 ---
        System.out.println("Calculating Multiplication...");
        driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        driver.findElement(By.id("com.google.android.calculator:id/clr")).click(); // Clear

        // --- 4. Division: 8 / 2 = 4 ---
        System.out.println("Calculating Division...");
        driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        
        System.out.println("All mathematical operations executed successfully!");
        
        Thread.sleep(2000);
        driver.quit();
    }
}
