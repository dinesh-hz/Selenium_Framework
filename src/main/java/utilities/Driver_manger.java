package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver_manger {

	private static  WebDriver driver = null;

	public static WebDriver getDriver() {

		
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		Driver_manger.driver = driver;
	}

	public static void lanuchbrowser(String browsername) {
		switch (browsername) {

		case "chrome":

			WebDriverManager.chromedriver().setup();
			/*
			 * ChromeOptions chromeOptions = new ChromeOptions();
			 * chromeOptions.addArguments("--remote-allow-origins=*");
			 */
			driver = new ChromeDriver();
			driver.manage().window().maximize();

			break;

		case "firefox":

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

			break;

		case "edge":

			WebDriverManager.edgedriver().setup();
			EdgeOptions d = new EdgeOptions();
			d.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(d);
			driver.manage().window().maximize();

			break;

		default:

			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions2 = new ChromeOptions();
			chromeOptions2.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(chromeOptions2);
			driver.manage().window().maximize();

			break;
		}

	}

}
