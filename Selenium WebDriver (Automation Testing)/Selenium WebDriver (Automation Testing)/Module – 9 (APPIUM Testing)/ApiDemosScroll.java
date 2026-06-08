import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class ApiDemosScroll {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting ApiDemos Scroll Test on Real Device...");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "MyAndroidPhone");
        
        // IMPORTANT: Replace with your actual physical phone's UDID
        caps.setCapability(MobileCapabilityType.UDID, "YOUR_UDID_HERE"); 
        caps.setCapability(MobileCapabilityType.APP, "C:\\Path\\To\\ApiDemos-debug.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(2000);

        // Click on 'Views' to access a long list of options
        driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();

        System.out.println("Scrolling down the list to find the 'WebView' option...");
        
        // Scroll through all the options until 'WebView' is found
        // Note: If you are using Appium Java Client 7.x, use MobileBy.AndroidUIAutomator
        // If you are using Appium Java Client 8.x+, use AppiumBy.androidUIAutomator
        driver.findElement(io.appium.java_client.MobileBy.AndroidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"WebView\").instance(0))"
        ));
        
        System.out.println("Successfully scrolled through the options and located WebView!");
        
        Thread.sleep(2000);
        driver.quit();
    }
}
