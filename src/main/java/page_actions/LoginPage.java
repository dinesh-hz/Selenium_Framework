package page_actions;

import Page_locators.Login_Locaters;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import utilities.Bass_Class;


public class LoginPage extends Bass_Class {


    Login_Locaters Locators = new Login_Locaters();


    /// ////////////////////////////////////////////////////
    public void entreusername(String usernmae) {


        try {
            Locators.username.sendKeys(usernmae);
            //Locators.username.sendKeys(getCellData(2,2);
        } catch (Exception e) {
            handleException(e, "Username field not found due to incorrect XPath.");
        }

    }

    public void entrepassword(String password) {

        Locators.password.sendKeys(password);

    }

    public void clicklogin_button() {

        Locators.login_btn.click();
    }

    public void click_forgot_button() {

        Locators.Forgotpassword.click();
    }

    public String isverifyforgotpagehome() {

        return Locators.verifyforgotpage.getText();
    }

    public boolean verifyUsernameBoxVisibility() {

        return ElementDisplay(Locators.username, ElementStatus.isDisplayed);

    }

    public boolean verifyUsernameBoxisenabled() {


        return ElementDisplay(Locators.username, ElementStatus.isEnabled);

    }

    public boolean verifypasswordBoxVisibility() {
        return ElementDisplay(Locators.username, ElementStatus.isDisplayed);


    }

    public boolean verifypasswordBoxisenabled() {


        return ElementDisplay(Locators.password, ElementStatus.isEnabled);


    }

    public String verifyRequiredusernameerror() {

        return Locators.Requirederror_username_mesg.getText();

    }

    public String verifyRequiredpassworderror() {

        return Locators.Requirederror_password_mesg.getText();

    }

    public String verify_Invalid_errormessage() {

        return Locators.Invaliderror_mesg.getText();

    }

    public boolean isverifyloginbuttondisplay() {

        return ElementDisplay(Locators.login_btn, ElementStatus.isDisplayed);

    }

    public boolean isverifyloginbuttonenable_or_disable() {


        return ElementDisplay(Locators.login_btn, ElementStatus.isEnabled);


    }

}
