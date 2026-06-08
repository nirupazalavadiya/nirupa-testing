package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitUtils;

public class LoginPage extends BasePage {

    // Assuming generic selectors for an e-commerce login page
    @FindBy(id = "username") // Adjust based on actual site if different
    private WebElement usernameInput;

    @FindBy(id = "password") // Adjust based on actual site if different
    private WebElement passwordInput;

    @FindBy(id = "loginBtn") // Adjust based on actual site if different
    private WebElement loginButton;

    private By loginErrorMessage = By.cssSelector(".error-message");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        WaitUtils.waitForElementToBeVisible(driver, By.id("username"), 10);
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public HomePage clickLogin() {
        loginButton.click();
        return new HomePage(driver);
    }
    
    public HomePage loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        return clickLogin();
    }
}
