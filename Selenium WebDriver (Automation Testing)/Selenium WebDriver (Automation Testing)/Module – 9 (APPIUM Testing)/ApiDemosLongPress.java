import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.time.Duration;

public class ApiDemosLongPress {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting ApiDemos Long Press Test on Real Device...");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "MyAndroidPhone");
        
        // IMPORTANT: Replace with your actual physical phone's UDID
        caps.setCapability(MobileCapabilityType.UDID, "YOUR_UDID_HERE"); 
        caps.setCapability(MobileCapabilityType.APP, "C:\\Path\\To\\ApiDemos-debug.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(2000);

        // 1. Navigate through the menus to the 'Custom Adapter' page
        driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']")).click();

        // 2. Locate the element we want to long press
        WebElement peopleNamesElement = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        
        // 3. Perform the Long Press Action (Using modern W3C Actions)
        System.out.println("Performing long press to open the side menu...");
        Actions action = new Actions(driver);
        action.clickAndHold(peopleNamesElement)
              .pause(Duration.ofSeconds(2)) // Hold for 2 seconds to trigger long press
              .release()
              .perform();
        
        System.out.println("Long press executed successfully and menu opened!");
        
        Thread.sleep(3000);
        driver.quit();
    }
}
