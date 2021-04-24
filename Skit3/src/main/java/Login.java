import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login extends Driver {


    public Login(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.facebook.com/");
    }

    public boolean isLoadedNotLoggedIn() throws InterruptedException {
        Thread.sleep(5000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"_9ay7\"]"))).isDisplayed();

    }

    public void login(String user, String password) throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys(user);
        Thread.sleep(3000);
        driver.findElement(By.id("pass")).sendKeys(password);
        Thread.sleep(3000);
        driver.findElement(By.name("login")).click();
        Thread.sleep(3000);
    }


    public String getErrorMessage() {
        WebElement errorPage = driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
        return errorPage.getText();
    }
}