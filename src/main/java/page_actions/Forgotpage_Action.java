package page_actions;

import Page_locators.Forgot_Locaters;
import utilities.Bass_Class;

public class Forgotpage_Action extends Bass_Class {

	Forgot_Locaters forget = new Forgot_Locaters();
	
/*	public static Forgotpage getinstenen;

	public Forgotpage() {

	}

	public static Forgotpage getInstance() {
		if (getinstenen == null) {

			getinstenen = new Forgotpage();
		}

		return getinstenen;
	}*/

	public boolean isResetPasswordHeadingVisible() {

		 return forget.reset_password_Text.isDisplayed();

	}

	public String getResetPasswordHeadingText() {
		return forget.reset_password_Text.getText();
	}



}
