package Dataprvder_testng;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Example_Login_Test_with_DataProvider {


    // this hardcore dataprovider


    public class LoginTest {

        // this are hardcode all datas here ...u can see the values...that is out put also it can  come out two value like username and password

        @Test(dataProvider = "loginData")
        public void loginTest(String username, String password) {
            System.out.println("Testing login with: " + username + " / " + password);

            // Example (if using Selenium WebDriver):
            // WebDriver driver = new ChromeDriver();
            // driver.get("https://example.com/login");
            // driver.findElement(By.id("username")).sendKeys(username);
            // driver.findElement(By.id("password")).sendKeys(password);
            // driver.findElement(By.id("loginButton")).click();
            //
            // Assert.assertTrue(driver.findElement(By.id("logout")).isDisplayed());
            // driver.quit();
        }

        @DataProvider(name = "loginData")
        public Object[][] getData() {
            return new Object[][]{
                    {"admin@example.com", "admin123"},
                    {"user1@example.com", "user123"},
                    {"user2@example.com", "user456"}
            };
        }
    }

}
