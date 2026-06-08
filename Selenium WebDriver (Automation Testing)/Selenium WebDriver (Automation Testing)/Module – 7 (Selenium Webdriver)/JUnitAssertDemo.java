
import org.junit.Assert;
import org.junit.Test;

public class JUnitAssertDemo {
    
    @Test
    public void testAssertMethods() {
        // Sample data for testing
        String str1 = "JUnit";
        String str2 = "JUnit";
        String str3 = "Test";
        String str4 = null;
        int val1 = 5;
        int val2 = 6;
        String[] expectedArray = {"one", "two", "three"};
        String[] resultArray = {"one", "two", "three"};

        // 1. assertEquals: Checks if two values are equal
        Assert.assertEquals("Strings should be equal", str1, str2);
        
        // 2. assertTrue: Checks if a condition is true
        Assert.assertTrue("val1 should be less than val2", val1 < val2);
        
        // 3. assertFalse: Checks if a condition is false
        Assert.assertFalse("val1 should not be greater than val2", val1 > val2);
        
        // 4. assertNotNull: Checks if an object is not null
        Assert.assertNotNull("str1 should not be null", str1);
        
        // 5. assertNull: Checks if an object is null
        Assert.assertNull("str4 should be null", str4);
        
        // 6. assertSame: Checks if two object references point to the same object
        Assert.assertSame("str1 and str2 should point to the same object", str1, str2); 
        
        // 7. assertNotSame: Checks if two object references do not point to the same object
        Assert.assertNotSame("str1 and str3 should not point to the same object", str1, str3);
        
        // 8. assertArrayEquals: Checks if two arrays are equal
        Assert.assertArrayEquals("Arrays should be equal", expectedArray, resultArray);
        
        System.out.println("All Assert methods passed successfully!");
    }
}
