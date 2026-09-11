package p1;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class CalculatorTest {

    AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("emulator-5554");

        options.setAppPackage("com.example.calc");
        options.setAppActivity("com.example.calc.MainActivity");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );
    }

    @Test
    public void verifyCalculatorLaunch() {

        System.out.println("Calculator launched successfully");

        Assert.assertNotNull(driver);
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}