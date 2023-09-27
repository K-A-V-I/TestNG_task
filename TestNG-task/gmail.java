package testNG;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class gmail{
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
      System.setProperty("webdriver.chrome.driver", "C:/Users/kavi1/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.google.com/");
      //  driver.manage().window().maximize();
      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testGmailLogin() {
        WebElement usernameInput = driver.findElement(By.id("identifierId"));
        usernameInput.sendKeys("kaviayirpsm@gmail.com");
        WebElement nextButton = driver.findElement(By.id("identifierNext"));
        nextButton.click();
        WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(30));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id =\"password\"]/div[1]/div / div[1]/input")));
        passwordInput.sendKeys("K@v!1810");
        WebElement passwordNextButton = driver.findElement(By.id("passwordNext"));
        passwordNextButton.click();
       System.out.println("Login success");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
