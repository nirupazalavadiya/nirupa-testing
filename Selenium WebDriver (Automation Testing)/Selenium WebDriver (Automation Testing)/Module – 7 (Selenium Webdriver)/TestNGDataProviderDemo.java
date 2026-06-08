
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProviderDemo {

    // 1. Create a DataProvider method that returns a 2D array of objects
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
            {"userA@demo.com", "passA"},
            {"userB@demo.com", "passB"},
            {"userC@demo.com", "passC"}
        };
    }

    // 2. Link the @Test method to the DataProvider using its name
    @Test(dataProvider = "loginData")
    public void testLoginWithDataProvider(String username, String password) {
        System.out.println("Testing login with DataProvider data -> Username: " + username + " | Password: " + password);
        // Inside a real script, you would insert the WebDriver code here
        // e.g. driver.findElement(By.id("email")).sendKeys(username);
    }
}
