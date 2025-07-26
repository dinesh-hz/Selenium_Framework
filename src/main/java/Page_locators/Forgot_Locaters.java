package Page_locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Forgot_Locaters {
	
	
	
	@FindBy(xpath = "//h6[text()='Reset Password']")
	public WebElement reset_password_Text;

	public WebElement getReset_password_Text() {
		return reset_password_Text;
	}
	
	

}
