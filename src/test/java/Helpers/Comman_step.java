package Helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.Driver_manger;

public class Comman_step {

	public static Comman_step instanses = null;

	

	public static Comman_step getinstance() {

		if (instanses == null) {
			instanses = new Comman_step();

		}
		return instanses;

	}

	
	 
	 

	public void highlightElement(WebElement webElement) {
		try {
			JavascriptExecutor excuter = (JavascriptExecutor) Driver_manger.getDriver();
			excuter.executeScript("arguments[0].setAttribute('style','border: 3px solid red');", webElement);
		} catch (Exception e) {

		}
		

	}
}

	
	

 
 
