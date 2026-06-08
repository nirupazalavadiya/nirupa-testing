
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonLoop {
    public static void main(String[] args) throws InterruptedException {
        // Initialize the browser driver
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();
            
            // Opening the required practice website mentioned in the assignment
            driver.get("https://demo.automationtesting.in/Register.html");
            System.out.println("Opened the registration page.");
            
            Thread.sleep(2000); // Give it some time to load
            
            // Finding all the radio buttons for Gender
            // Inspecting the page shows that the name attribute for gender radio buttons is 'radiooptions'
            List<WebElement> genderRadioButtons = driver.findElements(By.name("radiooptions"));
            
            System.out.println("Found " + genderRadioButtons.size() + " radio buttons for Gender.");
            
            // Using a for-loop to iterate and select each radio button one by one
            for (int i = 0; i < genderRadioButtons.size(); i++) {
                WebElement radioButton = genderRadioButtons.get(i);
                
                // Clicking the current radio button in the loop
                String value = radioButton.getAttribute("value");
                System.out.println("Clicking radio button at index " + i + " (Value: " + value + ")");
                radioButton.click();
                
                // Adding a pause so we can visually see the selection changing
                Thread.sleep(1500); 
                
                // Verifying if the radio button is actually selected
                if(radioButton.isSelected()) {
                    System.out.println("Verified: Radio button '" + value + "' is successfully selected.");
                }
            }
            
            System.out.println("Finished looping through all radio buttons.");

        } catch (Exception e) {
            System.out.println("Uh oh, something went wrong: " + e.getMessage());
        } finally {
            // Closing the browser to clean up
            driver.quit();
        }
    }
}
