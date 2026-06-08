import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class KeywordDrivenLogin {
    // Make driver static so it can be accessed inside our switch cases
    static WebDriver driver;

    public static void main(String[] args) {
        // Path to the Excel file containing the keywords
        // You must create a 'Keywords.xlsx' file with the exact words from your screenshot in Column A!
        String excelFilePath = "Keywords.xlsx";

        try {
            System.out.println("Opening Keyword Excel file: " + excelFilePath);
            // 1. Read the Excel File using Apache POI
            FileInputStream fis = new FileInputStream(new File(excelFilePath));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0); // Get the first sheet
            
            int rowCount = sheet.getLastRowNum();
            System.out.println("Found " + (rowCount + 1) + " keywords to execute.");
            
            // 2. Loop through each row to read the keyword
            for (int i = 0; i <= rowCount; i++) {
                
                // We assume the keywords are in the first column (Column A, Index 0)
                String keyword = sheet.getRow(i).getCell(0).getStringCellValue().trim().toLowerCase();
                System.out.println("------------------------------------");
                System.out.println("Executing Keyword: '" + keyword + "'");
                
                // 3. Switch statement to execute actions based on the keyword
                switch (keyword) {
                    case "open browser":
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--start-maximized"); // Prevent maximize timeout error
                        driver = new ChromeDriver(options);
                        break;
                        
                    case "enter url":
                        driver.get("https://demo.automationtesting.in/SignIn.html");
                        Thread.sleep(2000);
                        break;
                        
                    case "click signin":
                        // Since we went straight to SignIn.html, we are already on the sign in page.
                        // We will just print a message.
                        System.out.println("We are already on the Sign In page.");
                        break;
                        
                    case "enter email":
                        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
                        emailField.clear();
                        // In a simple keyword framework, test data is often hardcoded in the script
                        // or read from an adjacent column. We'll hardcode it since the screenshot only shows keywords.
                        emailField.sendKeys("rahul.sanghavi.mca@gmail.com"); 
                        break;
                        
                    case "enter password":
                        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
                        passwordField.clear();
                        passwordField.sendKeys("rahul12345");
                        break;
                        
                    case "click login":
                        WebElement enterButton = driver.findElement(By.id("enterbtn"));
                        enterButton.click();
                        Thread.sleep(3000); // Wait for the login attempt to process
                        break;
                        
                    case "click logout":
                        // Attempt to find a logout button if login was successful
                        try {
                            WebElement logoutBtn = driver.findElement(By.xpath("//a[contains(text(),'Log out') or contains(text(),'Logout')]"));
                            logoutBtn.click();
                            System.out.println("Logged out successfully.");
                        } catch (Exception e) {
                            System.out.println("No logout button found (Login likely failed due to invalid credentials).");
                        }
                        break;
                        
                    case "close browser":
                        if (driver != null) {
                            driver.quit();
                            System.out.println("Browser closed successfully.");
                        }
                        break;
                        
                    default:
                        System.out.println("ERROR: Keyword '" + keyword + "' is not recognized by the framework.");
                        break;
                }
                
                // Add a small pause between steps to make it easier to watch visually
                Thread.sleep(1000);
            }
            
            // Clean up
            workbook.close();
            fis.close();
            System.out.println("------------------------------------");
            System.out.println("Keyword Driven Test execution finished!");

        } catch (Exception e) {
            System.out.println("An error occurred. Make sure you created 'Keywords.xlsx' exactly as shown in your screenshot!");
            System.out.println("Error details: " + e.getMessage());
        }
    }
}
