package page_actions;

import org.openqa.selenium.support.PageFactory;

import Page_locators.Singup_Locaters;
import utilities.Bass_Class;
import utilities.Driver_manger;
import utilities.contText;

public class SingupPage extends Bass_Class {
	
	
	Singup_Locaters locters = null;
	
	public SingupPage() {
		
		this.locters=new Singup_Locaters();
		
        PageFactory.initElements(Driver_manger.getDriver(),locters);

	}
	
	
	
	public void filluptheNewSinguppage() throws InterruptedException {
		
		locters.Createaccount_btn.click();

		waitForSeconds(3000);



		locters.firstname.sendKeys(contText.name);
		
		locters.surname.sendKeys(contText.sname);
		
		locters.mobil_mailid.sendKeys(contText.mailid);

		waitForSeconds(3000);

		try {
			locters.reentermail.sendKeys(contText.mailid);

		} catch (Exception e) {
			e.getStackTrace();
		}

		locters.password.sendKeys(contText.passsowrddd);
		
		selectFromDropdown(locters.data,Dropdowntype.text,contText.data);
		selectFromDropdown(locters.month, Dropdowntype.text, contText.month);
		selectFromDropdown(locters.year, Dropdowntype.text, contText.year);
		
		locters.male.click();

		waitForSeconds(3000);
		
		locters.signup_btn.click();


	}
	


}
