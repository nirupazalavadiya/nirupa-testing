import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class GeneralStoreSwipe {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting General Store Swipe Test...");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        // Update this path to where your General-Store.apk is saved
        caps.setCapability(MobileCapabilityType.APP, "C:\\Path\\To\\General-Store.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(3000);

        // 1. Bypass the login screen to get to the products menu
        System.out.println("Logging in to access the products menu...");
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul");
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(3000);

        // 2. Perform a Swipe / Scroll action to find a specific shoe further down the menu
        System.out.println("Swiping down the menu to find 'Jordan 6 Rings'...");
        
        // Using UiScrollable which is the standard, most reliable way to swipe to an element in Android/Appium
        // Note: If you are using Appium Java Client 7.x, use MobileBy.AndroidUIAutomator
        // If you are using Appium Java Client 8.x+, use AppiumBy.androidUIAutomator
        driver.findElement(io.appium.java_client.MobileBy.AndroidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"
        ));
        
        System.out.println("Successfully swiped the menu to the target product!");
        
        Thread.sleep(2000);
        driver.quit();
    }
}
