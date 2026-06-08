import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DataDrivenLogin {
    public static void main(String[] args) {
        // Path to the Excel file we will read from
        // Make sure to create a 'TestData.xlsx' file in your project folder with the emails and passwords!
        String excelFilePath = "TestData.xlsx";

        try {
            System.out.println("Opening Excel file: " + excelFilePath);
            // 1. Read the Excel File using Apache POI
            FileInputStream fis = new FileInputStream(new File(excelFilePath));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0); // Get the very first sheet
            
            // 2. Setup WebDriver
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized"); // Using the reliable maximize method
            WebDriver driver = new ChromeDriver(options);
            
            // Navigate to the SignIn page
            System.out.println("Navigating to SignIn page...");
            driver.get("https://demo.automationtesting.in/SignIn.html");
            Thread.sleep(2000);
            
            // 3. Loop through the rows in the Excel sheet
            int rowCount = sheet.getLastRowNum();
            System.out.println("Found " + (rowCount + 1) + " rows of data in the Excel file.");
            
            for (int i = 0; i <= rowCount; i++) {
                // Get Email from Column A (Index 0)
                String email = sheet.getRow(i).getCell(0).getStringCellValue();
                // Get Password from Column B (Index 1)
                String password = sheet.getRow(i).getCell(1).getStringCellValue();
                
                System.out.println("-------------------------------------------------");
                System.out.println("Testing login with: Email=" + email + " | Password=" + password);
                
                // Locate email, password, and enter button fields
                WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
                WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
                WebElement enterButton = driver.findElement(By.id("enterbtn"));
                
                // Clear fields before typing to ensure no leftover text
                emailField.clear();
                passwordField.clear();
                
                // Enter data from the Excel sheet into the website
                emailField.sendKeys(email);
                passwordField.sendKeys(password);
                
                // Click Enter button
                enterButton.click();
                Thread.sleep(2000); // Wait for the website to process the login
                
                // 4. Check if login was successful
                WebElement errorMsg = null;
                try {
                    errorMsg = driver.findElement(By.id("errormsg"));
                } catch (Exception e) {
                    // Element not found means no error message
                }
                
                if (errorMsg != null && errorMsg.isDisplayed()) {
                    System.out.println("RESULT: Login FAILED for " + email + " (Invalid Email or Password)");
                } else {
                    System.out.println("RESULT: Login SUCCESSFUL for " + email);
                    // If login was successful, you would navigate back to the SignIn page for the next test
                    // driver.navigate().back(); 
                    // Thread.sleep(2000);
                }
            }
            
            // Close everything properly
            workbook.close();
            fis.close();
            driver.quit();
            System.out.println("-------------------------------------------------");
            System.out.println("Data Driven Test completed successfully.");

        } catch (Exception e) {
            System.out.println("An error occurred! Did you create the TestData.xlsx file?");
            System.out.println("Error details: " + e.getMessage());
        }
    }
}
