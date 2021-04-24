import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class Test_Skit {

    private WebDriver driver;

    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viki\\Downloads\\chromedriver.exe");
        return new ChromeDriver();
    }

    @BeforeTest
    public void setup() {
        driver = getDriver();
    }

    @Test
    public void invalidCredentials() throws InterruptedException {
        Login login1=new Login(driver);
        login1.open();
        login1.login("emailm.com", "randomPass");
        String errorMsg = driver.findElement(By.cssSelector("div[class='_9ay7']")).getText();
        assertNotEquals("Success", errorMsg);
    }

    @Test
    public void emptyUsername() throws InterruptedException {
        Login login1=new Login(driver);
        login1.open();
        login1.login("", "randomPass");
        String errorMsg = driver.findElement(By.cssSelector("div[class='_9ay7']")).getText();
        System.out.println(errorMsg);
        assertEquals("The email or mobile number you entered isn’t connected to an account. Find your account and log in.", errorMsg);
    }

    @Test
    public void successfulLogin() throws InterruptedException {
        Login login1=new Login(driver);
        login1.open();
        login1.login("skit_test@hotmail.com", "testSkit");
        assertTrue(new ExpectedPage(driver).isLoaded());
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}