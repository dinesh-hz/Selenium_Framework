package page_actions;

import org.openqa.selenium.support.PageFactory;

import Page_locators.Singup_Locaters;
import utilities.Bass_Class;
import utilities.Driver_manger;
import utilities.contText;

public class SingupPage extends Bass_Class {
	
	
	Singup_Locaters singuppagelocater = null;
	
	public SingupPage() {
		
		this.singuppagelocater=new Singup_Locaters();
		
        PageFactory.initElements(Driver_manger.getDriver(),singuppagelocater);

	}
	
	
	
	public void filluptheNewSinguppage() throws InterruptedException {
		
		singuppagelocater.Createaccount_btn.click();
		
		wait_class(3000);

		
		singuppagelocater.firstname.sendKeys(contText.name);
		
		singuppagelocater.surname.sendKeys(contText.sname);
		
		singuppagelocater.mobil_mailid.sendKeys(contText.mailid);
		
		wait_class(3000);

		try {
			singuppagelocater.reentermail.sendKeys(contText.mailid);

		} catch (Exception e) {
			e.getStackTrace();
		}

		singuppagelocater.password.sendKeys(contText.passsowrddd);
		
		selecte_class(singuppagelocater.data, "text", contText.data);
		
		selecte_class(singuppagelocater.month, "text", contText.month);

		selecte_class(singuppagelocater.year, "text", contText.year);
		
		singuppagelocater.male.click();

		wait_class(3000);
		
		singuppagelocater.signup_btn.click();


	}
	
	public void closeTheBrowser() throws InterruptedException {
		
		wait_class(300);
		
		Driver_manger.getDriver().quit();

	}

}
