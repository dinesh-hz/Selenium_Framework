package page_actions;

import Page_locators.Home_Locaters;
import Page_locators.Login_Locaters;
import utilities.Bass_Class;

public class LoginPage_Action extends Bass_Class {

    private final Home_Locaters homeLocators = new Home_Locaters();
    private final Login_Locaters loginLocators = new Login_Locaters();


    public void enterUsername(String username) {
        try {
            loginLocators.username.click();
            loginLocators.username.clear();
            waitForSeconds(1);
            loginLocators.username.sendKeys(username);
        } catch (Exception e) {
            handleException(e, "Unable to locate or interact with the username field.");
        }
    }


    public void enterPassword(String password) {
        try {
            loginLocators.password.clear();
            waitForSeconds(1);
            loginLocators.password.sendKeys(password);
        } catch (Exception e) {
            handleException(e, "Unable to locate or interact with the password field.");
        }
    }


    public void clickLoginButton() {
        loginLocators.login_btn.click();
    }


    public void clickForgotPasswordLink() {
        loginLocators.Forgotpassword.click();
    }


    public boolean isDashboardVisible() {
        return ElementDisplay(homeLocators.Dashboard, ElementStatus.isDisplayed);
    }


    public boolean isUsernameBoxVisible() {
        return ElementDisplay(loginLocators.username, ElementStatus.isDisplayed);
    }


    public boolean isUsernameBoxEnabled() {
        return ElementDisplay(loginLocators.username, ElementStatus.isEnabled);
    }


    public boolean isPasswordBoxVisible() {
        return ElementDisplay(loginLocators.password, ElementStatus.isDisplayed);
    }


    public boolean isPasswordBoxEnabled() {
        return ElementDisplay(loginLocators.password, ElementStatus.isEnabled);
    }


    public String getUsernameRequiredErrorText() {
        return loginLocators.Requirederror_username_mesg.getText();
    }


    public String getPasswordRequiredErrorText() {
        return loginLocators.Requirederror_password_mesg.getText();
    }


    public boolean isInvalidErrorMessageDisplayed() {
        Bass_Class.waitForSeconds(5);
        return loginLocators.Invaliderror_mesg.isDisplayed();
    }


    public String getInvalidErrorMessage() {
        return loginLocators.Invaliderror_mesg.getText();
    }


    public boolean isLoginButtonVisible() {
        return ElementDisplay(loginLocators.login_btn, ElementStatus.isDisplayed);
    }


    public boolean isLoginButtonEnabled() {
        return ElementDisplay(loginLocators.login_btn, ElementStatus.isEnabled);
    }


    public void logoutUser() {
        try {
            loginLocators.logmanu.click();
            waitForSeconds(2);
            loginLocators.Logout_buton.click();
        } catch (Exception e) {
            handleException(e, "Failed to perform logout operation.");
        }
    }
}
