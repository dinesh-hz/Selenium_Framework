package Page_locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import utilities.Driver_manger;

public class Login_Locaters {

	public Login_Locaters() {
		PageFactory.initElements(Driver_manger.getDriver(), this);

	}
	@FindBy(xpath = "//input[@name='username']")
	public WebElement username;

	@FindBy(name = "passwordd")
	public WebElement password;

	@FindBy(xpath = "//button[text()=' Login ']")  
	public WebElement login_btn;

	@FindBy(xpath = "//p[text()='Forgot your password? ']")
	public WebElement Forgotpassword;
	
	
	
	@FindBy(xpath = "//h6[text()='Reset Password']")
	public WebElement verifyforgotpage;
	
	
	@FindBy(xpath = "div[@class='orangehrm-login-branding']/img")
	public WebElement Loginpage_verify;

	@FindBy(xpath = "//p[text()='Invalid credentials']")
	public WebElement Invaliderror_mesg;

	@FindBy(xpath = "(//span[text()='Required'])[1]")
	public WebElement Requirederror_username_mesg;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span")
	public WebElement Requirederror_password_mesg;
	
}
