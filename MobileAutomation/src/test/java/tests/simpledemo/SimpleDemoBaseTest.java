package tests.simpledemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class SimpleDemoBaseTest {

    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("emulator-5554");

        options.setAppPackage("com.example.myapplication");
        options.setAppActivity(
            "com.example.myapplication.week4.Optimization"
        );

        driver = new AndroidDriver(
            new URL("http://127.0.0.1:4723"),
            options
        );

        System.out.println("App launched successfully");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}