import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumEmulatorConnection {
    public static void main(String[] args) {
        System.out.println("Starting Appium Emulator Connection...");

        // DesiredCapabilities tells Appium what kind of device and app we want to test
        DesiredCapabilities caps = new DesiredCapabilities();

        // 1. Set the Platform and Device details for the EMULATOR
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        // 'emulator-5554' is the default name for the first Android Studio emulator
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); 

        // 2. Set the App details (ApiDemos app)
        // If the app is not installed, provide the absolute path to the .apk file on your computer
        caps.setCapability(MobileCapabilityType.APP, "C:\\Path\\To\\Your\\ApiDemos-debug.apk");
        
        // Alternatively, if the app is already installed on the emulator, use appPackage and appActivity:
        caps.setCapability("appPackage", "io.appium.android.apis");
        caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

        try {
            // 3. Connect to the Appium Server running on your local machine (default port 4723)
            // Note: In newer Appium 2.0+, the "/wd/hub" suffix is often removed, 
            // but keeping it is standard for Appium 1.x taught in most courses.
            URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");

            // 4. Initialize the AndroidDriver to launch the app
            System.out.println("Connecting to Appium server and launching ApiDemos on Emulator...");
            AndroidDriver driver = new AndroidDriver(appiumServerUrl, caps);
            
            System.out.println("Successfully opened ApiDemos app on the Emulator!");

            // Add a small pause so you can see the app open
            Thread.sleep(5000);

            // 5. Close the app and session
            driver.quit();
            System.out.println("Session closed.");

        } catch (MalformedURLException e) {
            System.out.println("The Appium server URL is invalid.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An error occurred while connecting to the emulator.");
            e.printStackTrace();
        }
    }
}
