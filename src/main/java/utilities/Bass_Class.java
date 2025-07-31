package utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bass_Class extends Driver_manger {

	protected WebDriverWait wait;

	public Bass_Class() {

		this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60)); // Global timeout
	}
/// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public WebElement waitForVisibility(By locator) {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}

	public WebElement waitForClickability(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public Boolean waitForTextPresent(By locator, String text) {
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	public Boolean waitForInvisibility(By locator) {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void waitForPageLoadComplete() {
		wait.until(getDriver -> ((JavascriptExecutor) getDriver())
				.executeScript("return document.readyState").equals("complete"));
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void set_URL(String APPURL) {
		
		getDriver().get(APPURL);

	}

	public void clickingOnwebElement(WebElement element, long waittimesecond) {

		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waittimesecond));

		WebElement elements = null;

		elements = wait.until(ExpectedConditions.elementToBeClickable(element));

		elements.click();
	}

	public void selecte_class(WebElement webelement, String selecte_type, String select_value) {

		Select select = new Select(webelement);

		switch (selecte_type) {
		case "index":

			select.selectByIndex(Integer.parseInt(select_value));

			break;
		case "value":

			select.selectByValue(select_value);

			break;
		case "text":
			select.selectByVisibleText(select_value);

			break;
		case "multiple":
			select.isMultiple();

			break;

		default:

			break;
		}

	}

	public void mouseHoverAndClickElemnt(WebElement web_movelelemnt) {

		Actions actions = new Actions(getDriver());

		actions.moveToElement(web_movelelemnt).click().perform();

	}

	public void Actions_class(WebElement drag_element, WebElement Drop_element) {

		Actions actions = new Actions(getDriver());

		actions.dragAndDrop(drag_element, Drop_element).perform();
	}

	public void navigate_class(String type) {

		switch (type) {
		case "back":

			getDriver().navigate().back();

			break;
		case "forward":
			getDriver().navigate().forward();
			break;
		case "refresh":

			getDriver().navigate().refresh();

			break;

		default:
			break;
		}

	}

	public void navigate__URL(String url) {

		getDriver().navigate().to(url);

	}

	public WebElement locater_Element(String locater_type, String locater_path) {

		switch (locater_type) {

		case "id":
			return getDriver().findElement(By.id(locater_path));

		case "className":

			return getDriver().findElement(By.className(locater_path));

		case "name":

			return getDriver().findElement(By.name(locater_path));

		case "xpath":

			return getDriver().findElement(By.xpath(locater_path));

		case "tagname":

			return getDriver().findElement(By.tagName(locater_path));

		case "csselecter":

			return getDriver().findElement(By.cssSelector(locater_path));

		default:
			break;
		}

		return null;

	}

	public void frame_class(Integer type) {

		getDriver().switchTo().frame(type);

	}

	public void alert_class(String type) {

		switch (type) {

		case "accept":
			getDriver().switchTo().alert().accept();
			break;
		case "dismiss":
			getDriver().switchTo().alert().dismiss();
			break;

		case "getText":
			getDriver().switchTo().alert().getText();
			break;

		case "wait":
			try {
				getDriver().switchTo().alert().wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;

		/*
		 * default:
		 * 
		 * break;
		 */
		}

	}

	public void alert_sendkey(String type) {
		getDriver().switchTo().alert().sendKeys(type);

	}

	public void java_wait_class(long waittimesecond) {



		try {
			Thread.sleep(waittimesecond);
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}



	public void sendkey_Element(WebElement elementname, String key) {

		elementname.click();
		// elementname.clear();
		elementname.sendKeys(key);

	}

	public String selenium_class(WebElement element_name, String type_method) {

		switch (type_method) {
		case "clear":

			element_name.clear();

			break;
		case "click":
			element_name.click();
			break;
		case "TagName":
			return element_name.getTagName();
		case "submit":

			element_name.submit();

			break;
		case "gettext":

			return element_name.getText();

		/*
		 * default: break;
		 */
		}

		return null;

	}

	public void screen_Full_shot(String location_url) throws IOException {

		TakesScreenshot a = (TakesScreenshot) getDriver();

		File get = a.getScreenshotAs(OutputType.FILE);

		File set = new File(location_url);

		FileUtils.copyFile(get, set);

	}

	public void screen_Crop_shot(WebElement element_Name, String location_url) throws IOException {

		File get = element_Name.getScreenshotAs(OutputType.FILE);

		File set = new File(location_url);

		FileUtils.copyFile(get, set);

	}

	public void Scroll_Screen_class(WebElement element_name) {

		JavascriptExecutor scr = (JavascriptExecutor) getDriver();

		scr.executeScript("arguments[0].scrollIntoView();", element_name);

	}

	public String window_handle() {

		return getDriver().getWindowHandle();

	}

	public Set<String> allwindow() {

		return getDriver().getWindowHandles();

	}

}
