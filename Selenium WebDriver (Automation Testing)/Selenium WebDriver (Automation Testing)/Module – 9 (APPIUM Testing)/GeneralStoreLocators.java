import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class GeneralStoreLocators {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting General Store Locator Test...");
        
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        // Update this path to where your General-Store.apk is saved
        caps.setCapability(MobileCapabilityType.APP, "C:\\Path\\To\\General-Store.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(3000); // Wait for the app to open

        // 1. Locator for the 'Name' text field (Using ID)
        System.out.println("Locating Name Field and entering text...");
        WebElement nameField = driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
        nameField.sendKeys("Rahul Testing");

        // 2. Locator for the 'Country' Dropdown (Using ID)
        System.out.println("Locating Dropdown and opening it...");
        WebElement dropdown = driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));
        dropdown.click();
        Thread.sleep(1000); // Wait for dropdown animation

        // Select 'Argentina' from the dropdown list (Using XPath)
        System.out.println("Selecting Argentina from the dropdown...");
        WebElement country = driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']"));
        country.click();
        
        System.out.println("Successfully interacted with Name field and Dropdown using locators!");
        
        Thread.sleep(2000);
        driver.quit();
    }
}
