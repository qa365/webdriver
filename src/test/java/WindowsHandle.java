import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowsHandle extends BaseTestClass{


    @Test
    public void windowsHandlesTest() {

        goToTestPage();
        clickLinkForNewWindow();
        verifyAmountWindows();
        switchToSecondWindow();
        verifyWindowsTitles();
        verifyTextWindow();

    }

    private void verifyWindowsTitles() {

        String title = driver.getTitle();
        Assert.assertEquals(title, "New Window");

    }

    private void verifyTextWindow() {

        String pageText = driver.getPageSource();
        boolean textFor = pageText.contains("New Window");
        Assert.assertTrue(textFor);
    }

    private void verifyAmountWindows() {

        Set<String> windowsHandles = driver.getWindowHandles();
        int actualNumbers = windowsHandles.size();
        int expectedNumber = 2;
        Assert.assertEquals(actualNumbers, expectedNumber);
    }


    private void switchToSecondWindow() {

        Set<String> windowHandles = driver.getWindowHandles();
        String[] handlesArray = windowHandles.toArray(new String[]{});
        String switchedWindow = handlesArray[1];
        driver.switchTo().window(switchedWindow);

    }

    private void clickLinkForNewWindow() {

        WebElement clickLink = driver.findElement(By.linkText("Click Here"));
        clickLink.click();

    }

    private void goToTestPage() {

        driver.get(WINDOWS_HANDLE_URL);

    }
}
