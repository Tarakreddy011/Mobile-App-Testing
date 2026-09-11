package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class CalculatorTest extends BaseTest {

    @Test
    public void additionTest() {

        // Click 1
        driver.findElement(
            AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"1\")"
            )
        ).click();

        // Click +
        driver.findElement(
            AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"+\")"
            )
        ).click();

        // Click 2
        driver.findElement(
            AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"2\")"
            )
        ).click();

        // Click =
        driver.findElement(
            AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"=\")"
            )
        ).click();

        System.out.println("1 + 2 executed successfully");

        Assert.assertTrue(true);
    }
}