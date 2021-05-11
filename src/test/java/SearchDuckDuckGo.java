import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.print.DocFlavor;

import static java.lang.Thread.sleep;

public class SearchDuckDuckGo extends BaseTestClass {

    private static final String DUCK_DUCK_GO_URL = "https://duckduckgo.com/";


    @Test
    public void searchDuckDuckGo() {

        goToDuckDuckSearchPage();
        typeSearchRequest();
        submitSearchRequest();
        waitForElement();
        verifyResultsPage();
        waitBeforeCloseBrowser(3);

    }


    private void waitBeforeCloseBrowser (int numbersOfSeconds) {

        try {
            sleep(numbersOfSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void waitForElement() {

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'ab054')]")));

    }


    private void verifyResultsPage() {

        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'ab054')]"));
        boolean result = element.isDisplayed();
        Assert.assertEquals(result, true);

    }


    private void submitSearchRequest() {

        driver.findElement(By.name("q")).submit();

    }

    private void typeSearchRequest() {

        driver.findElement(By.name("q")).sendKeys("Aleksei Barabash git");

    }

    private void goToDuckDuckSearchPage() {

        driver.get(DUCK_DUCK_GO_URL);

    }

}
