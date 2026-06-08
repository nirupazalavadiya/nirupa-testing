import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumRealDeviceConnection {
    public static void main(String[] args) {
        System.out.println("Starting Appium Real Device Connection...");

        // DesiredCapabilities tells Appium what kind of device and app we want to test
        DesiredCapabilities caps = new DesiredCapabilities();

        // 1. Set the Platform and Device details for a REAL DEVICE
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        // For real devices, the device name can be anything descriptive
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "MyAndroidPhone"); 
        
        // **CRITICAL FOR REAL DEVICES**: You must provide the exact UDID of your phone.
        // You get this by connecting your phone via USB, enabling USB Debugging, 
        // and running 'adb devices' in your command prompt.
        caps.setCapability(MobileCapabilityType.UDID, "YOUR_PHONE_UDID_HERE"); // Example: "RZ8M20P8L4W"

        // 2. Set the App details (ApiDemos app)
        caps.setCapability(MobileCapabilityType.APP, "C:\\Path\\To\\Your\\ApiDemos-debug.apk");
        caps.setCapability("appPackage", "io.appium.android.apis");
        caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

        try {
            // 3. Connect to the local Appium Server
            URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");

            // 4. Initialize the AndroidDriver to launch the app
            System.out.println("Connecting to Appium server and launching ApiDemos on Real Device...");
            AndroidDriver driver = new AndroidDriver(appiumServerUrl, caps);
            
            System.out.println("Successfully opened ApiDemos app on the physical Real Device!");

            // Add a small pause so you can see the app open on your phone screen
            Thread.sleep(5000);

            // 5. Close the app and session
            driver.quit();
            System.out.println("Session closed.");

        } catch (MalformedURLException e) {
            System.out.println("The Appium server URL is invalid.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An error occurred while connecting to the real device.");
            System.out.println("Did you turn on 'USB Debugging' in your phone's Developer Options?");
            e.printStackTrace();
        }
    }
}
