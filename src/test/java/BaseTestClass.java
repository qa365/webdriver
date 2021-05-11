import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTestClass {

     WebDriver driver;

    //Static Variables:
    public static final String WINDOWS_HANDLE_URL = "https://the-internet.herokuapp.com/windows";



    @BeforeSuite
    public void openBrowser() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/driver.macOS.arm64.firefox/geckodriver");
        driver = new FirefoxDriver();
    }


}
