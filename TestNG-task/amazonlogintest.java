package testNG;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class amazonlogintest {

    private WebDriver driver;
    private String baseUrl = "https://www.amazon.in/";
    private String validUsername = "8489221073";
    private String validPassword = "1810Kavi";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/kavi1/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testAmazonLogin() {
        WebElement signInLink = driver.findElement(By.id("nav-link-accountList"));
        signInLink.click();
        WebElement emailInput = driver.findElement(By.id("ap_email"));
        emailInput.sendKeys(validUsername);
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
        WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(30));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password")));
        passwordInput.sendKeys(validPassword);
        WebElement signInSubmitButton = driver.findElement(By.id("signInSubmit"));
        signInSubmitButton.click();
        WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(amazonLogo.isDisplayed(), "Login successful!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
