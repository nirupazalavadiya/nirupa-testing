import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HybridDrivenLogin {
    // Driver made static for switch case accessibility
    static WebDriver driver;

    public static void main(String[] args) {
        // You must create a 'HybridData.xlsx' file with Keywords in Column A, and Data in Column B
        String excelFilePath = "HybridData.xlsx";

        try {
            System.out.println("Opening Hybrid Excel file: " + excelFilePath);
            // 1. Read the Excel File
            FileInputStream fis = new FileInputStream(new File(excelFilePath));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0); // Get the first sheet
            
            int rowCount = sheet.getLastRowNum();
            System.out.println("Found " + (rowCount + 1) + " steps to execute.");
            
            // 2. Loop through each row
            for (int i = 0; i <= rowCount; i++) {
                
                // Read Keyword from Column A
                String keyword = "";
                Cell keywordCell = sheet.getRow(i).getCell(0);
                if (keywordCell != null) {
                    // .toString() safely converts string cells or numeric cells
                    keyword = keywordCell.toString().trim().toLowerCase(); 
                }
                
                // Read Data from Column B
                String data = "";
                Cell dataCell = sheet.getRow(i).getCell(1);
                if (dataCell != null) {
                    data = dataCell.toString().trim();
                }
                
                System.out.println("------------------------------------");
                System.out.println("Executing Keyword: '" + keyword + "' | Data Provided: '" + data + "'");
                
                // 3. Switch statement (Hybrid Framework combining Keywords + Data)
                switch (keyword) {
                    case "open browser":
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--start-maximized"); 
                        driver = new ChromeDriver(options);
                        break;
                        
                    case "enter url":
                        // If data says "null" or is empty, we fall back to the prompt's URL
                        if (data.isEmpty() || data.equalsIgnoreCase("null")) {
                            driver.get("https://demo.automationtesting.in/SignIn.html");
                        } else {
                            driver.get(data);
                        }
                        Thread.sleep(2000);
                        break;
                        
                    case "click signin":
                        System.out.println("Already on a Sign In page, action skipped.");
                        break;
                        
                    case "enter email":
                        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
                        emailField.clear();
                        // Instead of hardcoding, we use the DATA column!
                        emailField.sendKeys(data); 
                        break;
                        
                    case "enter password":
                        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
                        passwordField.clear();
                        // Instead of hardcoding, we use the DATA column!
                        passwordField.sendKeys(data); 
                        break;
                        
                    case "click login":
                        WebElement enterButton = driver.findElement(By.id("enterbtn"));
                        enterButton.click();
                        Thread.sleep(3000); 
                        break;
                        
                    case "click logout":
                        try {
                            WebElement logoutBtn = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
                            logoutBtn.click();
                            System.out.println("Logged out successfully.");
                        } catch (Exception e) {
                            System.out.println("No logout button found.");
                        }
                        break;
                        
                    case "close browser":
                        if (driver != null) {
                            driver.quit();
                            System.out.println("Browser closed successfully.");
                        }
                        break;
                        
                    default:
                        if (!keyword.isEmpty()) {
                            System.out.println("ERROR: Keyword '" + keyword + "' not recognized.");
                        }
                        break;
                }
                
                Thread.sleep(1000); // Pause for visualization
            }
            
            // Clean up
            workbook.close();
            fis.close();
            System.out.println("------------------------------------");
            System.out.println("Hybrid Driven Test execution finished!");

        } catch (Exception e) {
            System.out.println("An error occurred. Make sure you created 'HybridData.xlsx'!");
            System.out.println("Error details: " + e.getMessage());
        }
    }
}
