package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Bass_Class extends Driver_manger {

    // private static WebElement highlightedElement;

    //------>Expilt wait----//
    public static WebElement waitForVisibility(By locator) {
        return getwait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickability(By locator) {
        return getwait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static Boolean waitForTextPresent(By locator, String text) {
        return getwait().until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public static Boolean waitForInvisibility(By locator) {
        return getwait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForPageLoadComplete() {
        try {
            getwait().until(driver -> {
                Object state = ((JavascriptExecutor) getDriver()).executeScript("return document.readyState");
                return state != null && state.toString().equals("complete");
            });
        } catch (Exception e) {
            handleException(e, "⚠️ Page did not load completely within the wait time: ");
        }
    }

    /// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void set_URL(String APPURL) {

        getDriver().get(APPURL);
    }

    //(Fluent Wait)
   /* public static WebElement waitForelementLocter(By locator, int timeout, int pollingTime) {
        Wait<WebDriver> fluentWait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);
        return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }*/

    public static List<WebElement> findElements(By locator) {
        return getDriver().findElements(locator);
    }

    /// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void Navigate(NavigationType type) {
        switch (type) {
            case BACK:
                getDriver().navigate().back();
                break;
            case FORWARD:
                getDriver().navigate().forward();
                break;
            case REFRESH:
                getDriver().navigate().refresh();
                break;
            default:
                System.err.println("⚠️ Invalid navigation type: " + type);
        }
    }

    /// ////////////////////////////////////////////////////////////////////////////////////////////
    public static void navigateToURL(String url) {

        getDriver().navigate().to(url);
    }

    public static void sendKeys(WebElement element, String text) {
        try {
            element.click();
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            handleException(e, "Failed to send keys");
        }
    }

    public static void selectFromDropdown(WebElement element, Dropdowntype type, String value) {
        Select select = new Select(element);
        String selected = "";
        switch (type) {
            case index:
                select.selectByIndex(Integer.parseInt(value));
                selected = select.getFirstSelectedOption().getText();
                break;
            case value:
                select.selectByValue(value);
                selected = select.getFirstSelectedOption().getText();

                break;
            case text:
                select.selectByVisibleText(value);
                selected = select.getFirstSelectedOption().getText();
                break;
            default:
                System.err.println("⚠️ Invalid select type: " + type);
        }
    }

    public static boolean isMultipleSelect(WebElement element) {
        try {
            Select select = new Select(element);
            return select.isMultiple();  // returns true if multiple selection allowed
        } catch (Exception e) {
            handleException(e, "is not a MultipleSelect");
            return false;
        }
    }

    public static boolean isVerifyBrokenImage(WebElement element) {
        try {
            String src = element.getAttribute("src");
            String naturalWidth = element.getAttribute("naturalWidth");

            if (src == null || src.isEmpty()) {
                //   System.err.println("⚠️ Missing 'src' attribute for image element.");
                return true;
            }

            if (naturalWidth == null || naturalWidth.equals("0")) {
                //     System.err.println("❌ Broken Image: " + src);
                return true;
            }

            // Optional: verify HTTP response (recommended in frameworks)
            HttpURLConnection connection = (HttpURLConnection) new URL(src).openConnection();
            connection.setRequestMethod("HEAD");
            int statusCode = connection.getResponseCode();

            //    System.err.println("❌ Broken URL: " + src + " | Status: " + statusCode);
            return statusCode >= 400;

            //  System.out.println("✅ Valid Image: " + src + " | Status: " + statusCode);

        } catch (Exception e) {
            handleException(e, "Error verifying image element.");
            return true;
        }
    }

    // ✅ Mouse and Actions
    public static void mouseoverAndClick(WebElement element) {
        new Actions(getDriver()).moveToElement(element).click().perform();
    }

    public static void mouseoverAndClickRight(WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element)
                .contextClick().sendKeys(element, Keys.ESCAPE)
                .perform();
    }

    public static void mouseoverreles(WebElement element) {
        new Actions(getDriver()).moveToElement(element).release().perform();
    }

    public static void dragAndDrop(WebElement source, WebElement target) {
        new Actions(getDriver()).dragAndDrop(source, target).perform();
    }

    /// ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //------>only for dynamic elements-------->
    public static WebElement findElementBy(LocatorType type, String locatorValue) {
        try {
            switch (type) {
                case ID:
                    return getDriver().findElement(By.id(locatorValue));
                case CLASS_NAME:
                    return getDriver().findElement(By.className(locatorValue));
                case NAME:
                    return getDriver().findElement(By.name(locatorValue));
                case XPATH:
                    return getDriver().findElement(By.xpath(locatorValue));
                case TAG_NAME:
                    return getDriver().findElement(By.tagName(locatorValue));
                case CSS_SELECTOR:
                    return getDriver().findElement(By.cssSelector(locatorValue));
                default:
                    throw new IllegalArgumentException("⚠️ Invalid locator type: " + type);
            }
        } catch (Exception e) {
            throw new FrameworkElementNotFoundException(
                    "❌ Failed to find element: " + locatorValue + " using type " + type, e
            );
        }
    }

    /// ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //✅ Alerts handler using enum
    public static String Alertshandle(AlertAction action) {
        try {
            getwait().until(ExpectedConditions.alertIsPresent());

            Alert alert = getDriver().switchTo().alert();

            switch (action) {
                case ACCEPT:
                    alert.accept();
                    // System.out.println("✅ Alert accepted");
                    break;

                case DISMISS:
                    alert.dismiss();
                    // System.out.println("✅ Alert dismissed");
                    break;

                case GET_TEXT:
                    return alert.getText();
                //  System.out.println("✅ Alert text: " + Dropdowntype.text);
                default:
                    System.err.println("⚠️ Unknown alert action: " + action);
                    break;
            }
        } catch (Exception e) {
            handleException(e, "⚠️ No alert found to handle");
        }
        return null;
    }

    /// ////////////////////////////////////////////////////////////////////////////////////////////////
    public static void AlertsendKeysTo(String value) {
        getDriver().switchTo().alert().sendKeys(value);
    }

    // ✅ Frame and Window Handling
    public static int switchToFrameByIndex(String tagName, int index) {
        try {
            List<WebElement> frames = getDriver().findElements(By.tagName(tagName));
            if (frames.isEmpty()) {
                throw new NoSuchFrameException("❌ No frames found with tag name: " + tagName);
            }
            if (index < 0 || index >= frames.size()) {
                throw new IndexOutOfBoundsException("⚠️ Invalid frame index: " + index + ". Total frames: " + frames.size());
            }

            WebElement frameElement = frames.get(index);
            getDriver().switchTo().frame(frameElement);
            return frames.size();
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to switch to frame: " + e.getMessage(), e);
        }
    }

    public static void switchToFrameByName(String name) {
        getDriver().switchTo().frame(name);
    }

    public static void switchToDefaultFrame() {
        getDriver().switchTo().defaultContent();
    }

    // ✅ Assertions / Verification Helpers
    public static boolean ElementDisplay(WebElement element, ElementStatus status) {
        try {
            switch (status) {
                case isDisplayed:
                    return element.isDisplayed();
                case isEnabled:
                    return element.isEnabled();
                case isSelected:
                    return element.isSelected();
                default:
                    System.err.println("⚠️ Invalid status type: " + status);
                    return false;
            }
        } catch (NoSuchElementException e) {
            handleException(e, "⚠️ Element not found:");
            return false;
        }
    }

    /// //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static String ElementAction(WebElement element, ElementAction action) {
        try {
            switch (action) {
                case CLEAR:
                    element.clear();
                    return "Cleared";
                case CLICK:
                    element.click();
                    return "Clicked";
                case SUBMIT:
                    element.submit();
                    return "Submitted";
                case GET_TEXT:
                    return element.getText();
                case GET_TAG:
                    return element.getTagName();
                default:
                    return "Invalid action";
            }
        } catch (Exception e) {
            handleException(e, "Error performing action: " + action);
            return null;
        }
    }

    /// /////////////////////////////////////////////////////////////

    // ✅ Screenshots
    public static String takeFullScreenshot(String savePath) throws IOException {
        File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        File dest = new File(savePath);
        FileUtils.copyFile(src, dest);
        return dest.getAbsolutePath();
    }

    public static String takeElementScreenshot(WebElement element, String savePath) throws IOException {
        File src = element.getScreenshotAs(OutputType.FILE);
        File dest = new File(savePath);
        FileUtils.copyFile(src, dest);
        return dest.getAbsolutePath();
    }

    public static void scroll_Screen(WebElement element) {

        JavascriptExecutor scr = (JavascriptExecutor) getDriver();

        scr.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public static String getTitle() {
        return getDriver().getTitle();
    }

   /* public static boolean isverifyText(WebElement element, String expected) {
        try {
            return element.getText().trim().equalsIgnoreCase(expected.trim());
        } catch (Exception e) {
            handleException(e, "the test is not verifyed");
            return false;
        }
    }*/

    public static String getWindowHandle() {
        return getDriver().getWindowHandle();
    }

    public static void getAllWindows(int tabIndex) {

        Set<String> windowHandles = getDriver().getWindowHandles();

        ArrayList<String> windowList = new ArrayList<>(windowHandles);

        getDriver().switchTo().window(windowList.get(tabIndex));
    }

    // ✅ Exception Handling
    public static void handleException(Exception e, String message) {
        System.err.println(e.getMessage() + "❌ " + message);
    }

    // ✅ Utility
    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L); // always use long literal
        } catch (Exception e) {
            Thread.currentThread().interrupt(); // restore interrupted state
            handleException(e, "⚠️ Thread was interrupted during wait: ");
        }
    }

    // Returns true if file is found, false otherwise
    public static boolean isFileDownloaded(String downloadLocation, String fileName) {
        try {
            File folder = new File(downloadLocation);
            File[] allFiles = folder.listFiles();

            if (allFiles != null) {
                for (File file : allFiles) {
                    if (file.getName().equals(fileName)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            handleException(e, "file not verifed");
            return false;
        }
    }

    public static void FileUpload(WebElement element, String filepath) {

        element.click();
        element.clear();

        element.sendKeys(filepath);

        //------------------Hidden File Input (when type="file" is hidden via CSS)-------------------//
        /*JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement hiddenInput = driver.findElement(By.cssSelector("input[type='file']"));

        js.executeScript("arguments[0].style.display='block';", hiddenInput); // make it visible
        hiddenInput.sendKeys("C:\\Users\\DELL\\Downloads\\resume.pdf");
*/

    }

    public static void multipleFilesuploades(WebElement element, String filePaths) {
        try {
            String joinedFiles = String.join("\n", filePaths); // supports multiple
            element.sendKeys(joinedFiles);
        } catch (Exception e) {
            handleException(e, "File upload failed");
        }
        // like this

       /* // Upload multiple files (if the input allows multiple selection)
        Filesupload(fileInput,
                "C:\\Users\\DELL\\Downloads\\dinu.jpg",
                "C:\\Users\\DELL\\Downloads\\test.txt"
        );*/
    }

    public static void NewTab() {
        // Open a new tab
        getDriver().switchTo().newWindow(WindowType.TAB);
    }

    public static void Movetoslidervalue(WebElement element, int startpoint, int endpoint) {

        Actions actions = new Actions(getDriver());
        actions.clickAndHold(element)
                .pause(Duration.ofSeconds(3))
                .moveByOffset(startpoint, endpoint)
                .release()
                .perform();
    }

    public static void moveSliderJS(WebElement slider, double targetValue) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript(
                    "arguments[0].value=arguments[1];" +
                            "arguments[0].dispatchEvent(new Event('input'));" +
                            "arguments[0].dispatchEvent(new Event('change'));",
                    slider, targetValue
            );
            System.out.println("✅ Slider moved via JavaScript → " + targetValue);
        } catch (Exception e) {
            System.err.println("❌ JS fallback failed: " + e.getMessage());
        }
    }

    public static void setPriceSliderValue(WebElement slider, int priceValue) {
        try {
            int sliderValue = Math.round(priceValue / 1000f);
            if (sliderValue < 0) sliderValue = 0;
            if (sliderValue > 130) sliderValue = 130;

            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript(
                    "arguments[0].value=arguments[1];" +
                            "arguments[0].dispatchEvent(new Event('input'));" +
                            "arguments[0].dispatchEvent(new Event('change'));",
                    slider, sliderValue
            );

            Thread.sleep(500);

            System.out.println("🎯 Target: ₹" + priceValue +
                    " | Displayed: " + slider.getAttribute("aria-valuetext"));
        } catch (Exception e) {
            handleException(e, "setpricelevel erroe");
        }
    }

    public enum NavigationType {
        BACK,
        FORWARD,
        REFRESH
    }

    public enum Dropdowntype {

        index,
        value,
        text
    }

    public enum LocatorType {
        ID,
        CLASS_NAME,
        NAME,
        XPATH,
        TAG_NAME,
        CSS_SELECTOR
    }

    // ✅ Enum for alert actions
    public enum AlertAction {
        ACCEPT,
        DISMISS,
        GET_TEXT
    }

    //  public static void Movetoslidervalue(WebElement element,  targetValue) {

       /* double step = 0.5;
        double current = Double.parseDouble(element.getAttribute("value"));
        int steps = (int) Math.round((targetValue - current) / step);

        element.click();

        for (int i = 0; i < Math.abs(steps); i++) {
            if (steps > 0)
                element.sendKeys(Keys.ARROW_RIGHT);
            else
                element.sendKeys(Keys.ARROW_LEFT);
        }

        //System.out.println("✅ Slider moved to: " + element.getAttribute("value"));*/
    // }

    public enum ElementStatus {

        isDisplayed,
        isEnabled,
        isSelected
    }

    public enum ElementAction {
        CLEAR,
        CLICK,
        SUBMIT,
        GET_TEXT,
        GET_TAG
    }

    // ✅ Custom Runtime Exception (can be nested) for findelement
    public static class FrameworkElementNotFoundException extends RuntimeException {
        public FrameworkElementNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
