
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleDropdownSelection {
    public static void main(String[] args) throws InterruptedException {
        // Initiating the WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Maximizing the window for better visibility
            driver.manage().window().maximize();
            
            // Navigating to a site with a multiple selection dropdown for practice
            driver.get("https://demoqa.com/select-menu");
            
            // Locating the standard <select> element which allows multiple selections
            WebElement carsDropdown = driver.findElement(By.id("cars"));
            
            // Using the Select class provided by Selenium to handle dropdowns
            Select select = new Select(carsDropdown);
            
            // Checking if the dropdown actually supports multiple selections
            if(select.isMultiple()) {
                System.out.println("Yay! This dropdown allows multiple selections.");
                
                // 1. Selecting by visible text
                select.selectByVisibleText("Volvo");
                Thread.sleep(1000);
                
                // 2. Selecting by index (Audi is usually index 3)
                select.selectByIndex(3);
                Thread.sleep(1000);
                
                // 3. Selecting by value attribute
                select.selectByValue("saab");
                Thread.sleep(2000);
                
                System.out.println("Selected multiple items successfully.");
                
                // Deselecting one item just to practice deselecting
                select.deselectByVisibleText("Volvo");
                System.out.println("Deselected Volvo.");
                Thread.sleep(1000);
                
                // Deselecting all remaining items
                select.deselectAll();
                System.out.println("Deselected everything.");
                
            } else {
                System.out.println("Oops, this is a single-select dropdown.");
            }

        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            // Closing the driver
            driver.quit();
        }
    }
}
