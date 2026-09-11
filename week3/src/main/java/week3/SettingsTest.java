package week3;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class SettingsTest {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:deviceName", "emulator-5554");
        capabilities.setCapability("appium:appPackage", "com.android.settings");
        capabilities.setCapability("appium:appActivity", ".Settings");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                capabilities
        );

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    // TC01 - Verify Settings application launches
    @Test
    public void verifySettingsLaunch() {

        WebElement search = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.xpath("//*[@text='Search Settings']")
                )
        );

        Assert.assertTrue(search.isDisplayed());

        System.out.println("TC01 PASSED - Settings launched");
    }


    // TC02 - Verify Display & Touch
    @Test
    public void verifyDisplayAndTouch() {

        WebElement display = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//*[@text='Display & touch']")
                )
        );

        display.click();

        WebElement displayScreen = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.xpath("//*[contains(@text,'Display')]")
                )
        );

        Assert.assertTrue(displayScreen.isDisplayed());

        System.out.println("TC02 PASSED - Display & Touch opened");
    }


    // TC03 - Verify Settings Search
    @Test
    public void verifySearch() {

        // First click the Search Settings area
        WebElement searchButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//*[@text='Search Settings']")
                )
        );

        searchButton.click();

        // Now find the actual text input
        WebElement searchBox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.className("android.widget.EditText")
                )
        );

        searchBox.sendKeys("Display");

        Assert.assertTrue(searchBox.getText().contains("Display"));

        System.out.println("TC03 PASSED - Search worked");
    }


    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}