package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	
    protected static WebDriverWait wait;

	
	 public static WebDriverWait getWait() {
		return wait;
	}

	// Wait until element is visible
    public static void waitUntilVisible(By locator) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait until element is clickable
    public static void waitUntilClickable(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait until element is present in DOM
    public static void waitUntilPresent(By locator) {
        getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Wait until element is not visible
    public static void waitUntilInvisible(By locator) {
        getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // Wait until title contains text
    public static void waitUntilTitleContains(String titleFragment) {
        getWait().until(ExpectedConditions.titleContains(titleFragment));
    }

    // Wait until URL contains text
    public static void waitUntilUrlContains(String urlFragment) {
        getWait().until(ExpectedConditions.urlContains(urlFragment));
    }

    // Wait until alert is present
    public static void waitForAlert() {
        getWait().until(ExpectedConditions.alertIsPresent());
    }

    // Wait until frame is available and switch to it
    public static void waitForFrameAndSwitchToIt(By frameLocator) {
        getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    // Wait until element's text is a specific value
    public static void waitUntilTextIs(By locator, String text) {
        getWait().until(ExpectedConditions.textToBe(locator, text));
    }

    // Wait until element contains specific text
    public static void waitUntilTextContains(By locator, String text) {
        getWait().until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    // Wait for element attribute to contain value
    public static void waitUntilAttributeContains(By locator, String attr, String value) {
        getWait().until(ExpectedConditions.attributeContains(locator, attr, value));
    }

}
