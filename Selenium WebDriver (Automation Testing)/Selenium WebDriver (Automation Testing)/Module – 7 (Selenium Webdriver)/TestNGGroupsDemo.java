
import org.testng.annotations.Test;

public class TestNGGroupsDemo {
    
    // This test belongs only to the 'smoke' group
    @Test(groups = {"smoke"})
    public void loginTest() {
        System.out.println("Running Login Test - Part of [Smoke] Group");
    }

    // This test belongs to both 'smoke' and 'regression' groups
    @Test(groups = {"smoke", "regression"})
    public void homePageTest() {
        System.out.println("Running Home Page Test - Part of [Smoke, Regression] Groups");
    }

    // This test belongs only to the 'regression' group
    @Test(groups = {"regression"})
    public void cartTest() {
        System.out.println("Running Cart Test - Part of [Regression] Group");
    }
}
