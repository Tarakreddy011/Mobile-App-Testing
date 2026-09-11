package tests.simpledemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleDemoTest extends SimpleDemoBaseTest {

    // TC01 - Verify application launches
    @Test
    public void verifyAppLaunch() {

        Assert.assertNotNull(driver);

        System.out.println("TC01: Application launched successfully");
    }


    // TC02 - Verify compatibility dialog is displayed
    @Test
    public void verifyCompatibilityDialog() {

        WebElement okButton = driver.findElement(
            By.id("android:id/button2")
        );

        Assert.assertTrue(okButton.isDisplayed());

        System.out.println(
            "TC02: Compatibility dialog displayed successfully"
        );
    }


    // TC03 - Verify OK button works
    @Test
    public void verifyOKButton() {

        WebElement okButton = driver.findElement(
            By.id("android:id/button2")
        );

        Assert.assertTrue(okButton.isDisplayed());

        okButton.click();

        System.out.println(
            "TC03: OK button clicked successfully"
        );
    }


    // TC04 - Verify Don't Show Again button
    @Test
    public void verifyDontShowAgainButton() {

        WebElement dontShowAgain = driver.findElement(
            By.id("android:id/button1")
        );

        Assert.assertTrue(dontShowAgain.isDisplayed());

        dontShowAgain.click();

        System.out.println(
            "TC04: Don't Show Again clicked successfully"
        );
    }
}