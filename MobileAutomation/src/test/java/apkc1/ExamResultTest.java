package apkc1;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;

public class ExamResultTest {

    AndroidDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName("emulator-5554");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        options.setAppPackage("com.ega.examresult");
        options.setAppActivity(".MainActivity");

        driver = new AndroidDriver(
                URI.create("http://127.0.0.1:4723").toURL(),
                options
        );
    }

    // Test Case 1: Verify application launches
    @Test
    public void testApplicationLaunch() {

        String currentPackage = driver.getCurrentPackage();

        Assert.assertEquals(
                currentPackage,
                "com.ega.examresult",
                "Application did not launch correctly"
        );

        System.out.println(
                "Test 1 Passed: Application launched successfully"
        );
    }


   
    @Test
    public void testNotificationPermission() {

        // Locate the Allow button
        var allowButton = driver.findElement(
                AppiumBy.xpath(
                    "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']"
                )
        );

        
        Assert.assertTrue(
                allowButton.isDisplayed(),
                "Allow notification permission button is not displayed"
        );

        
        allowButton.click();

        System.out.println(
                "Test 2 Passed: Notification permission allowed successfully"
        );
    }


    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}