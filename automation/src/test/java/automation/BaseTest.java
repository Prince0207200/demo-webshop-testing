package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
//    public void setup(@Optional("chrome") String browser) {
    public void setup(@Optional("chrome") String browser) {
        switch(browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
           
            case "edge":
            	System.setProperty("webdriver.edge.driver", "C:\\Users\\DELL\\Downloads\\edgedriver_win64\\msedgedriver.exe");

                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" not supported.");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
